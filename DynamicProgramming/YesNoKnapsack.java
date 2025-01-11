package DynamicProgramming;

import java.util.Arrays;

public class YesNoKnapsack {
    public static int yesNoKnapsack(int[] weights, int[] values, int bagWeight) {
        int n = values.length;
        int[][] dp = new int[n][bagWeight+1];
        for (int j = 0; j <= bagWeight; j++) {
            if (weights[0] <= j) {
                dp[0][j] = values[0];
            } else {
                dp[0][j] = 0;
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= bagWeight; j++) {
                int notTake = dp[i - 1][weights[j]];
                int take = Integer.MIN_VALUE;
                if (weights[i] <= bagWeight)
                    take = values[i] + dp[i - 1][j - weights[j]];
                dp[i][weights[i]] = Math.max(notTake, take);
            }
        }
        return dp[n - 1][bagWeight - 1];
    }

    public static int recursiveApproach(int[] weights, int[] values, int[][] dp, int index, int bagWeight) {
        if (index == 0) {
            if (weights[0] < bagWeight) return values[0];
            else return 0;
        }
        if (dp[index][weights[index]] != -1) return values[index];
        int notTake = values[index] + recursiveApproach(weights, values, dp, index - 1, bagWeight - weights[index]);
        int take = Integer.MIN_VALUE;
        if (weights[index] < bagWeight)
            take = values[index] + recursiveApproach(weights, values, dp, index - 1, bagWeight - weights[index]);
        return dp[index][weights[index]] = Math.max(notTake, take);
    }

    public static void main(String[] args) {
        System.out.println(
                yesNoKnapsack(
                        new int[]{3, 2, 4, 5, 6},
                        new int[]{60, 50, 70, 80, 90},
                        10
                )
        );
    }
}
