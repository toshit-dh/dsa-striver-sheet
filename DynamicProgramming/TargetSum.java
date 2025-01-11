package DynamicProgramming;

import java.util.Arrays;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();

        // If the target is out of the possible bounds, return 0
        if (target > sum || target < -sum) {
            return 0;
        }

        int[][] dp = new int[n][2 * sum + 1];  // DP table for memoization
        for (int[] row : dp) {
            Arrays.fill(row, -1);  // Initialize DP table with -1 indicating uncalculated states
        }

        // Start the recursion with target shifted by 'sum'
        return recursiveApproach(dp, nums, sum, n - 1, target + sum);
    }

    // Recursive approach with memoization
    public static int recursiveApproach(int[][] dp, int[] nums, int sum, int index, int target) {
        // Base case: If no more elements to process
        if (index == -1) {
            return target == 0 ? 1 : 0;  // If the target is 0, it means we have found a valid combination
        }

        // If already computed, return the stored result
        if (dp[index][target] != -1) {
            return dp[index][target];
        }

        // Calculate the number of ways by adding or subtracting nums[index]
        int plus = 0;
        // Ensure the target + nums[index] is within the DP table bounds
        if (target + nums[index] <= 2 * sum) {
            plus = recursiveApproach(dp, nums, sum, index - 1, target + nums[index]);
        }

        int minus = 0;
        // Ensure the target - nums[index] is within the DP table bounds
        if (target - nums[index] >= 0) {
            minus = recursiveApproach(dp, nums, sum, index - 1, target - nums[index]);
        }

        // Store the result in DP table and return the sum of possibilities
        dp[index][target] = plus + minus;
        return dp[index][target];
    }

    public static void main(String[] args) {
        System.out.println(findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));  // Expected output: 5
    }
}
