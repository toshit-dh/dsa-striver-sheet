package Array;

import java.util.Arrays;

public class RemoveDuplicate {
    public static void main(String[] args) {
        int [] nums = new int[]{1,1,2};
        int k = removeDuplicates(nums);
        System.out.println(k);
        System.out.println(Arrays.toString(nums));
    }
    public static int removeDuplicates(int[] nums) {
        int count = 0;
        int element = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != element){
                nums[++count] = nums[i];
                element = nums[i];
            }
        }
        return count + 1;
    }
}
