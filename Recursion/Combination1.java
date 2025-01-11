package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Combination1 {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        recursiveCombination(list,new ArrayList<>(),candidates,0,target, candidates.length);
        return list;
    }
    public static void recursiveCombination(List<List<Integer>> answer,List<Integer> ds,int[] nums,int idx,int target,int n){
        if (target == 0) {
            answer.add(new ArrayList<>(ds));
            return;
        }
        if (idx == n || target < 0) return;
        ds.add(nums[idx]);
        recursiveCombination(answer,ds,nums,idx,target-nums[idx],n);
        ds.removeLast();
        recursiveCombination(answer,ds,nums,idx+1,target,n);

    }
    public static void main(String[] args) {
        var lists = combinationSum(new int[]{2,3,6,7},7);
        for (var list: lists){
            System.out.println(list);
        }
    }
}
