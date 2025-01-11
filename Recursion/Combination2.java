package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination2 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(candidates);
        recursiveCombination(list,new ArrayList<>(),candidates,0,target);
        return list;
    }
    public static void recursiveCombination(List<List<Integer>> answer,List<Integer> ds,int[] nums,int idx,int target){
        if (target == 0) {
            answer.add(new ArrayList<>(ds));
            return;
        }
        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i-1]) continue;
            if (nums[i] <= target) {
                ds.add(nums[i]);
                recursiveCombination(answer, ds, nums, i+1, target - nums[i]);
                ds.removeLast();
            }
        }

    }
    public static void main(String[] args) {
        var lists = combinationSum(new int[]{10,1,2,7,6,1,5},8);
        for (var list: lists){
            System.out.println(list);
        }
    }
}
