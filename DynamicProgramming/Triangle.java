package DynamicProgramming;

import java.util.Arrays;
import java.util.List;

public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int n  = triangle.size();
        int[] prev = new int[n];
        for (int i = 0; i < n; i++) {
            prev[i] = triangle.get(n-1).get(i);
        }
        for (int i = n-2; i >= 0; i--) {
            int[] current = new int[n];
            for (int j = 0; j <= i; j++) {
                current[j] = triangle.get(i).get(j) + Math.min(prev[j],prev[j+1]);
            }
            prev = current;
        }
        return prev[0];
    }
    public static int recursiveApproach(List<List<Integer>> triangle,int[][] dp,int n, int i, int j){
        if (i == n - 1) {
            return triangle.get(i).get(j);
        }
        if (dp[i][j]!=-1) return dp[i][j];
        int down = recursiveApproach(triangle,dp, n,i + 1, j);
        int diagonal = recursiveApproach(triangle,dp, n,i + 1, j + 1);
        return dp[i][j] = triangle.get(i).get(j) + Math.min(down, diagonal);
    }
    public static void main(String[] args) {
        System.out.println(
                minimumTotal(
                        List.of(
                                List.of(2),
                                List.of(3,4),
                                List.of(6,5,7),
                                List.of(4,1,8,3)
                        )
                )
        );
    }
}
