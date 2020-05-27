package monthlychallenege.may20;

import java.util.Arrays;

class ContiguousArray {

    public static void main(String[] args) {
        System.out.println(new ContiguousArray().findMaxLength(new int[]{0, 1, 0, 0, 1, 0, 0, 1, 1}));
    }

    public int findMaxLength(int[] nums) {
        int len = nums.length;

        if (len < 2) {
            return 0;
        } else if (len == 2) {
            return nums[0] != nums[1] ? 2 : 0;
        }

        int[] sums = new int[len];

        sums[0] = nums[0] == 0 ? -1 : 1;

        int min = sums[0];
        int max = sums[0];

        for (int i = 1; i < len; i++) {
            sums[i] = sums[i - 1] + (nums[i] == 0 ? -1 : 1);
            if (sums[i] > max) {
                max = sums[i];
            } else if (sums[i] < min) {
                min = sums[i];
            }
        }

        if (sums[len - 1] == 0) {
            return len;
        }

        int last0Idx = -1;
        int maxNon0Len = 0;

        int[] firstCounts = new int[max - min + 1];

        Arrays.fill(firstCounts, -1);

        for (int i = 0; i < len; i++) {
            if (sums[i] == 0) {
                last0Idx = i;
            }
            int idx = sums[i] - min;
            if (firstCounts[idx] == -1) {
                firstCounts[idx] = i;
            } else if (i - firstCounts[idx] > maxNon0Len) {
                maxNon0Len = i - firstCounts[idx];
            }
        }

        return Math.max(last0Idx + 1, maxNon0Len);
    }

}