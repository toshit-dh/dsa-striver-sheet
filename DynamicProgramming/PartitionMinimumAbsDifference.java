package DynamicProgramming;

import java.util.*;

public class PartitionMinimumAbsDifference {
    public static int minimumDifference(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        boolean[] prev = new boolean[sum + 1];
        prev[0] = true;
        if(Math.abs(nums[0]) <= sum) prev[Math.abs(nums[0])] = true;
        for (int i = 1; i < n; i++) {
            boolean[] current = new boolean[sum + 1];
            current[0] = true;
            for (int j = 1; j <= sum; j++) {
                boolean notTake = prev[j];
                boolean take = false;
                if (Math.abs(nums[i]) <= j) take = prev[j - Math.abs(nums[i])];
                current[j] = take || notTake;
            }
            prev = current;
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= sum/2; i++) {
            if (prev[i]){
                int s2 = sum - i;
                min = Integer.min(min,Math.abs(s2-i));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(minimumDifference(new int[]{-36, 36}));
    }
}
