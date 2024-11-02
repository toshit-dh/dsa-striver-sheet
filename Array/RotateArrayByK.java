package Array;

import java.util.Arrays;

public class RotateArrayByK {
    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums,int k){
        for (int i = 0; i < k; i++) {
            for(int j = 0;j < nums.length;j++){
                int temp = nums[i+1];
            
            }
        }
    }
}
