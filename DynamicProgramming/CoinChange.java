package DynamicProgramming;

import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                if (dp[j - coin] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }

    public static int recursiveApproach(int index, int[] coins, int[][] dp, int amount) {
        if (index == 0) return dp[index][amount] = amount % coins[0] == 0 ? amount / coins[0] : 0;
        int notTake = recursiveApproach(index - 1, coins, dp, amount);
        int take = Integer.MAX_VALUE;
        if (coins[index] <= amount) take = 1 + recursiveApproach(index, coins, dp, amount - coins[index]);
        return dp[index][amount] = Integer.min(take, notTake);
    }

    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{2,5,10,1}, 27));
    }
}
