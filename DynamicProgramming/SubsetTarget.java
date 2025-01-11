package DynamicProgramming;

import java.util.Arrays;

public class SubsetTarget {
    public static Boolean isSubsetSum(int[] arr, int target) {
    int n = arr.length;
    boolean[] prev = new boolean[target + 1];
    prev[0] = true;
    if (arr[0] <= target) prev[arr[0]] = true;
    for (int i = 1; i < n; i++) {
        boolean[] current = new boolean[target + 1];
        current[0] = true;
        for (int j = 1; j <= target; j++) {
            boolean notTake = prev[j];
            boolean take = false;
            if (arr[i] <= j) take = prev[j - arr[i]];
            current[j] = take || notTake;
        }
        prev = current;
    }
    return prev[target];
}


    public static boolean recursiveApproach(int[] arr, int[][] dp, int idx, int target) {
        if (target == 0) return true;
        if (idx == 0) return arr[0] == target;
        if (dp[idx][target] != -1) return dp[idx][target] == 1;
        boolean notTake = recursiveApproach(arr, dp, idx - 1, target);
        boolean take = false;
        if (arr[idx] <= target) take = recursiveApproach(arr, dp, idx - 1, target - arr[idx]);
        return (dp[idx][target] = notTake || take ? 1 : 0) == 1;
    }

    public static void main(String[] args) {
        System.out.println(isSubsetSum(
                new int[]{3, 34, 4, 12, 5, 2}, 9
        ));
    }
}
