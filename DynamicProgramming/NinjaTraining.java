package DynamicProgramming;

public class NinjaTraining {
//    public static int maximumPoints(int[][] arr, int n) {
//        int[][] dp = new int[n][4];
//        for (int[] row: dp){
//            Arrays.fill(row,-1);
//        }
//        return recursiveSolutionWithMemoization(dp,arr,n-1,3);
//    }

    public static int maximumPoints(int[][] arr, int n) {
        int[] prev = new int[4];
        prev[0] = Math.max(arr[0][1], arr[0][2]);
        prev[1] = Math.max(arr[0][0], arr[0][2]);
        prev[2] = Math.max(arr[0][0], arr[0][1]);
        prev[3] = Math.max(arr[0][0], Math.max(arr[0][1], arr[0][2]));
        for (int day = 1; day < n; day++) {
            int[] current = new int[4];
            for (int last = 0; last < 4; last++) {
                int max = 0;
                for (int task = 0; task < 3; task++) {
                    if (task != last) {
                        max = Math.max(max, arr[day][task] + prev[task]);
                    }
                }
                current[last] = max;
            }
            prev = current;
        }
        return prev[3];
    }

    public static int recursiveSolution(int[][] points, int day, int last) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last)
                    max = Integer.max(max, points[0][i]);
            }
            return max;
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last)
                max = Integer.max(max, points[day][i] + recursiveSolution(points, day - 1, i));
        }
        return max;
    }

    public static int recursiveSolutionWithMemoization(int[][] dp, int[][] points, int day, int last) {
        if (day == 0) {
            int max = 0;
            for (int i = 0; i < 3; i++) {
                if (i != last) {
                    max = Integer.max(max, points[0][i]);
                }
            }
            return max;
        }
        if (dp[day][last] != -1) return dp[day][last];
        int max = 0;
        for (int i = 0; i < 3; i++) {
            if (i != last) {
                max = Integer.max(max, points[day][i] + recursiveSolutionWithMemoization(dp, points, day - 1, i));
            }
        }
        dp[day][last] = max;
        return max;
    }

    public static void main(String[] args) {
        System.out.println(maximumPoints(
                new int[][]{
                        new int[]{1, 2, 5},
                        new int[]{3, 1, 1},
                        new int[]{3, 3, 3}
                },
                3
        ));
    }
}
