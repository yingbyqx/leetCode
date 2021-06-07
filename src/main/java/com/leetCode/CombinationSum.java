package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/** 40. 组合总和 II
 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

 candidates 中的每个数字在每个组合中只能使用一次。

 说明：

 所有数字（包括目标数）都是正整数。
 解集不能包含重复的组合。

 示例 1:

 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 所求解集为:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]

 示例 2:

 输入: candidates = [2,5,2,1,2], target = 5,
 所求解集为:
 [
 [1,2,2],
 [5]
 ]

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/combination-sum-ii
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));


    }



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        // candidates 中的数字可以无限制重复被选取
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        backtrace(result, tmpList, candidates, target, 0);
        return result;
    }


    public static void backtrace(List<List<Integer>> result, List<Integer> tmpList, int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        if (target < 0) return;

        for (int i = index; i < candidates.length; i++) {
//            if (target < 0) break;
//            target -= candidates[i]; // 这样写为什么会错？回退的时候会有问题 改变了target的值

            tmpList.add(candidates[i]);
            backtrace(result, tmpList, candidates, target - candidates[i], i);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
