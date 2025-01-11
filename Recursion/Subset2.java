package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset2 {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> powerSet = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>(), powerSet);
        return powerSet;
    }

    private static void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> powerSet) {
        powerSet.add(new ArrayList<>(current));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]);
            backtrack(nums, i + 1, current, powerSet);
            current.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> result = subsetsWithDup(nums);
        System.out.println(result);
    }
}
