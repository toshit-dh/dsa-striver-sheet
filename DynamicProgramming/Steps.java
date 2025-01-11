package DynamicProgramming;

import java.util.Arrays;

public class Steps {
    public static int climbStairs(int n) {
        int first = 1;
        int second = 1;
        for (int i = 2; i <= n; i++) {
            int temp = first + second;
            first = second;
            second = temp;
        }
        return second;
    }
    public static int recursiveApproach(int[] dp,int n){
        if (n == 0 || n == 1) return 1;
        if (dp[n-1]!=-1) return dp[n-1];
        return recursiveApproach(dp,n-1) + recursiveApproach(dp,n-2);
    }
    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
