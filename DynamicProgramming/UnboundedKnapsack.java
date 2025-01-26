package DynamicProgramming;

import java.util.Arrays;

public class UnboundedKnapsack {
    public static int knapSack(int[] val, int[] wt, int capacity) {
        int n = val.length;
        int[] prev = new int[capacity + 1];
        for (int j = 0; j <= capacity; j++) {
            prev[j] = (j / wt[0]) * val[0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= capacity; j++) {
                int notTake = prev[j];
                int take = Integer.MIN_VALUE;
                if (wt[i] <= j)
                    take = val[i] + prev[j - wt[i]];
                prev[j] = Integer.max(take, notTake);
            }
        }
        return prev[capacity];
    }

    public static int recursiveApproach(int index, int[] val, int[] wt, int[][] dp, int capacity) {
        if (index == 0) return dp[0][capacity] = capacity * val[0] / wt[0];
        if (dp[index][capacity] != -1) return dp[index][capacity];
        int notTake = recursiveApproach(index - 1, val, wt, dp, capacity);
        int take = Integer.MIN_VALUE;
        if (wt[index] < capacity) take = val[index] + recursiveApproach(index, val, wt, dp, capacity - wt[index]);
        return dp[index][capacity] = Integer.max(take, notTake);
    }

    public static void main(String[] args) {
        System.out.println(knapSack(
                new int[]{1, 1},
                new int[]{2, 1},
                3
        ));
    }
}
