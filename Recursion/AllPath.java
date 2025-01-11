//package Recursion;
//
//public class AllPath {
//    public static int uniquePaths(int m, int n) {
//        int t = m + n -2;
//        int r = m-1;
//        double res = 1;
//        for (int i = 0; i <= r; i++) {
//            res = res*(t-r+i)/i;
//        }
//        return res;
//    }
//
////    public static int board(int m, int n) {
////        int[] prev = new int[n];
////        prev[0] = 1;
////        for (int i = 0; i < m; i++) {
////            int[] temp = new int[n];
////            for (int j = 0; j < n; j++) {
////                if (j ==0) temp[j] = prev[i];
////                else
////                    temp[j] = prev[j] + temp[j-1];
////            }
////            prev = temp;
////        }
////        return prev[n-1];
////    }
//
//    public static void main(String[] args) {
//        System.out.println(uniquePaths(4, 4));
//    }
//}
