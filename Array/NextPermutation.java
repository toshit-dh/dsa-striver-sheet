package Array;

import java.util.Arrays;

public class NextPermutation {

    public static void nextPermutation(int[] nums) {
        int m = nums.length;
        int pivot = -1;
        for (int i = m - 1; i >= 1; i--) {
            if (nums[i-1] < nums[i]){
                pivot = i-1;
                break;
            }
        }
        if (pivot != -1) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = pivot; i < m; i++) {
                if (nums[i] <= min && nums[i] > nums[pivot]) {
                    min = nums[i];
                    minIndex = i;
                }
            }
            int temp = nums[pivot];
            nums[pivot] = nums[minIndex];
            nums[minIndex] = temp;
        };
        int n = m - (pivot + 1);
        for (int i = 0; i < n/2;i++){
            int temp2 = nums[pivot+i+1];
            nums[pivot+i+1] = nums[m-i-1];
            nums[m-i-1] = temp2;
        }
    }
    public static void main(String[] args) {
        int[] num = new int[]{2,3,1,3,3};
        nextPermutation(num);
        System.out.println(Arrays.toString(num));
    }

}
