package DynamicProgramming;

import java.util.Arrays;
import java.util.Random;

public class CoinChange2 {
    public static int change(int amount, int[] coins) {
        int n = coins.length;
        int[] prev = new int[amount+1];
        for (int i = 0; i <= amount; i++) {
            prev[i] = (i % coins[0]) == 0 ? 1 : 0;
        }
        for (int i = 1; i < n; i++) {
            int[] current = new int[amount+1];
            for (int j = 0; j <= amount; j++) {
                int notTake = prev[j];
                int take = 0;
                if (coins[i] <= j) take = current[j - coins[i]];
                current[j] = notTake + take;
            }
            prev = current;
        }
        return prev[amount];
    }

    public static int recursiveApproach(int index, int target, int[] coins, int[][] dp) {
        if (index == 0) {
            return dp[index][target] = (target % coins[index]) == 0 ? 1 : 0;
        }
        if (dp[index][target] != -1) return dp[index][target];
        int notTake = recursiveApproach(index - 1, target, coins, dp);
        int take = 0;
        if (coins[index] <= target) take = recursiveApproach(index, target - coins[index], coins, dp);
        return dp[index][target] = notTake + take;
    }

    public static void main(String[] args) {
        System.out.println(change(5, new int[]{1,2,5}));
    }
}
