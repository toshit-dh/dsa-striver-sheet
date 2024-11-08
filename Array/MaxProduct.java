package Array;

public class MaxProduct {
    public static int maxProduct(int[] nums) {
        int m = nums.length;
        int maxProduct = nums[0], currentMax = nums[0], currentMin = nums[0];
        for (int i = 1; i < m; i++) {
            int tempMax = currentMax;
            currentMax = Math.max(nums[i], Math.max(currentMax * nums[i], currentMin * nums[i]));
            currentMin = Math.min(nums[i], Math.min(tempMax * nums[i], currentMin * nums[i]));
            maxProduct = Math.max(maxProduct, currentMax);
        }
        return maxProduct;
    }

    public static void main(String[] args) {
        System.out.println(maxProduct(new int[]{-2, 0, -1}));
    }
}
