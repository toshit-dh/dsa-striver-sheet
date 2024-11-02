package Array;

import java.util.Arrays;

public class Rearrange {

    public static int[] rearrangeArray(int[] nums) {
        int m = nums.length;
        int[] rearrange = new int[m];
        int index = 0;
        for (int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(nums));
            for (int j = 0; j < i; j++) {
                if (nums[j] > 0){
                    rearrange[index++] = nums[j];
                }
            }
            for (int j = 0; j < i; j++) {
                if (nums[i] < 0){
                    rearrange[index++] = nums[j];
                }
            }
        }
        return rearrange;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(rearrangeArray(new int[]{3,1,-2,-5,2,-4})));
    }
}
