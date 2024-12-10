package Greedy;

import java.util.Arrays;
import java.util.Comparator;

public class NonOverlapping {
    public static int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        int freeTime = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            if (interval[0] >= freeTime) {
                freeTime = interval[1];
                count++;
            }
        }
        return n - count;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{1, 3}
        }));
    }
}
