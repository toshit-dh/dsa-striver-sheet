package DynamicProgramming;

public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] prev = new int[n];
        for (int i = 0; i < m; i++) {
            int[] current = new int[n];
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) current[j] = grid[i][j];
                else if (i == 0) {
                    current[j] = grid[i][j] + current[j - 1];
                } else if (j == 0) {
                    current[j] = grid[i][j] + prev[j];
                } else {
                    int up = grid[i][j] + prev[j];
                    int left = grid[i][j] + current[j - 1];
                    current[j] = Integer.min(up, left);
                }
            }
            prev = current;
        }
        return prev[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(minPathSum(
                new int[][]{
                        new int[]{1, 3, 1},
                        new int[]{1, 5, 1},
                        new int[]{4, 2, 1}
                }
        ));
    }
}
