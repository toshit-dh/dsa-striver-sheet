package Array;

public class MaxSumOfSubArray {
    public static int maxSubArray(int[] nums) {
        int m = nums.length;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i: nums) {
            sum += i;
            maxSum = Math.max(maxSum,sum);
            if (sum < 0) sum = 0;
        }
        return maxSum;
    }
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{1}));
    }
}