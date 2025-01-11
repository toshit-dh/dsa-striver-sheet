package DynamicProgramming;

import java.util.Arrays;

public class UniquePath2 {
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] current = new int[n];
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    current[j] = 0;
                } else if (i == 0 && j == 0) {
                    current[j] = 1;
                } else {
                    int up = (i > 0) ? prev[j] : 0;
                    int left = (j > 0) ? current[j - 1] : 0;
                    current[j] = up + left;
                }
            }
            prev = current;
            System.out.println(Arrays.toString(prev));
        }
        return prev[n - 1];
    }

    public static int recursiveMemoization(int[][] obstacleGrid, int[][] dp, int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        return dp[i][j] = recursiveMemoization(obstacleGrid, dp, i - 1, j) + recursiveMemoization(obstacleGrid, dp, i, j - 1);
    }

    public static int recursiveApproach(int[][] obstacleGrid, int i, int j) {
        if (i == 0 && j == 0) return 1;
        if (i < 0 || j < 0) return 0;
        if (obstacleGrid[i][j] == 1) return 0;
        return recursiveApproach(obstacleGrid, i - 1, j) + recursiveApproach(obstacleGrid, i, j - 1);
    }

    public static void main(String[] args) {
        System.out.println(
                uniquePathsWithObstacles(
                        new int[][]{
                                new int[]{0, 0, 0},
                                new int[]{0, 0, 0},
                                new int[]{0, 0, 0}
                        }
                )
        );
    }
}
