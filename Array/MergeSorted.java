package Array;

import java.util.Arrays;

public class MergeSorted {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = m + n - 1;
        int k = n - 1;
        while (i >= 0 && k >= 0) {
            if (nums1[i] > nums2[k]) {
                nums1[j--] = nums1[i--];
            } else {
                nums1[j--] = nums2[k--];
            }
        }
        while (k >= 0) {
            nums1[j--] = nums2[k--];
        }
    }

    public static void main(String[] args) {
        int[] num = new int[]{1, 2, 5, 7, 0, 0, 0};
        merge(num, 4, new int[]{3, 6, 8}, 3);
        System.out.println(Arrays.toString(num));
    }
}
