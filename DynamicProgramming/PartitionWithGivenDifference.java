package DynamicProgramming;

import java.util.Arrays;

public class PartitionWithGivenDifference {
    public static int countPartitions(int[] arr, int d) {
        int n = arr.length;
        int sum = Arrays.stream(arr).map(Math::abs).sum();
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;
        if(arr[0] <= sum) prev[arr[0]] = true;
        for (int i = 1; i < n; i++) {
            boolean[] current = new boolean[sum + 1];
            current[0] = true;
            for (int j = 1; j <= sum; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (arr[i] <= j) take = prev[j - arr[i]];
                current[j] = take || notTake;
            }
            prev = current;
        }
        System.out.println(Arrays.toString(prev));
        int count = 0;
        for (int i = 0; i <= sum; i++) {
            if (prev[i]){
                int s2 = sum - i;
                System.out.println(i);
                System.out.println(s2);
                if (i >= s2 && i - s2 == d) count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{1,1,1,1},0));
    }
}
