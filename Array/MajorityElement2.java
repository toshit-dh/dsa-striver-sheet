package Array;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums){
        int[] element = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int count1 = 0, count2 = 0;
        for (int i : nums) {
            if (i == element[0]) {
                count1++;
            } else if (i == element[1]) {
                count2++;
            } else if (count1 == 0) {
                element[0] = i;
                count1 = 1;
            } else if (count2 == 0) {
                element[1] = i;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int i : nums) {
            if (i == element[0]) count1++;
            else if (i == element[1]) count2++;
        }
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        if (count1 > n/3) list.add(element[0]);
        if (count2 > n/3) list.add(element[1]);
        return list;
    }
    public static void main(String[] args) {
        System.out.println(majorityElement(new int[]{1,2}));
    }
}
