package monthlychallenege.jun20;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

class ReconstructQueueOnHeight {

    public static void main(String[] args) {
        int[][] result = new ReconstructQueueOnHeight().reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
        Stream.of(result).forEach(res -> System.out.println(res[0] + ", " + res[1]));
    }

    public int[][] reconstructQueue(int[][] people) {
        if (people.length > 0) {
            Arrays.sort(people, (a1, a2) -> {
                if (a1[0] == a2[0] && a1[1] == a2[1]) {
                    return 0;
                } else if (a1[0] != a2[0]) {
                    return Integer.compare(a2[0], a1[0]);
                } else {
                    return Integer.compare(a1[1], a2[1]);
                }
            });

            Stack<int[]> stack = new Stack<>();
            stack.push(people[0]);

            for (int i = 1; i < people.length; i++) {
                int[] current = people[i];
                if (current[0] < stack.peek()[0]) {
                    stack.add(current[1], current);
                } else {
                    stack.add(current);
                }
            }

            return stack.toArray(new int[0][]);
        }

        return new int[0][];
    }
}