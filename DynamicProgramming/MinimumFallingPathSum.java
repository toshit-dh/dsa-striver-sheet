package DynamicProgramming;

public class MinimumFallingPathSum {
    public static int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] prev = new int[n];
        System.arraycopy(matrix[0], 0, prev, 0, n);
        for (int i = 1; i < m; i++) {
            int[] current = new int[n];
            for (int j = 0; j < n; j++) {
                int u = matrix[i][j] + prev[j];
                int ld = matrix[i][j];
                if (j - 1 >= 0) {
                    ld += prev[j - 1];
                } else {
                    ld = Integer.MAX_VALUE;
                }
                int rd = matrix[i][j];
                if (j + 1 < n) {
                    rd += prev[j + 1];
                } else {
                    rd = Integer.MAX_VALUE;
                }
                current[j] = Math.min(u, Math.min(ld, rd));
            }
            prev = current;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, prev[i]);
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minFallingPathSum(
                new int[][]{
                        new int[]{2, 1, 3},
                        new int[]{6, 5, 4},
                        new int[]{7, 8, 9}
                }
        ));
    }
}
