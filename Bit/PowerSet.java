package Bit;

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
    public static List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        int noOfSubset = 1<<n;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0;i < noOfSubset;i++){
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n;j++){
                if ((i&1<<j) != 0) subset.add(nums[j]);
            }
            subsets.add(subset);
        }
        return subsets;
    }
    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,2}));
    }
}
