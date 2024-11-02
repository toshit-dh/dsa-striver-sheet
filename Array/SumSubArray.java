package Array;

public class SumSubArray {
    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        if((nums.length == 1 && nums[0] == k) || nums[0] == k || nums[nums.length-1] == k) count++;
        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i]+nums[i+1] == k){
                count++;
            };
        }
        return count;
    }
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{-1,-1,1},1));
    }
}
