package monthlychallenege.may20;

class MaxSubarraySumCircular {

    public static void main(String[] args) {
        System.out.println(new MaxSubarraySumCircular().maxSubarraySumCircular(new int[]{3, 5, -3, -1, 2, 4, -1}));
    }

    public int maxSubarraySumCircular(int[] input) {
        int max = -30000, min = 30000, total = 0, cMax = 0, cMin = 0;

        for (int curr : input) {
            cMax = Math.max(cMax + curr, curr);
            max = Math.max(cMax, max);
            cMin = Math.min(cMin + curr, curr);
            min = Math.min(cMin, min);
            total += curr;
        }

        return max > 0 ? Math.max(max, total - min) : max;
    }
}