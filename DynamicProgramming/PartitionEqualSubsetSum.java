package DynamicProgramming;

import java.util.Arrays;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum >> 1;
        if (sum % 2 != 0) return false;
        boolean[] prev = new boolean[target + 1];
        if(nums[0] <= target) prev[0] = true;
        for (int i = 1; i < n; i++) {
            boolean[] current = new boolean[target + 1];
            current[0] = true;
            for (int j = 1; j <= target; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (nums[i] <= j) take = prev[j - nums[i]];
                current[j] = take || notTake;
            }
            prev = current;
        }
        return prev[target];
    }

    public static void main(String[] args) {
        System.out.println(canPartition(new int[]{1,5,11,5}));
    }
}
