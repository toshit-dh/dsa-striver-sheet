package Array;

import java.util.Arrays;
import java.util.List;

public class RemoveElement {
    public static void main(String[] args) {
        int [] nums = new int[]{3,3,3,3};
        int k = removeElement(nums,3);
        System.out.println(Arrays.toString(nums));
        System.out.println(k);
    }
    public static int removeElement(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[count++] = nums[i];
            }
        }
        return count;
    }
}
