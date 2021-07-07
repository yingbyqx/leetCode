package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。
 * <p>
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * <p>
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-iii
 */
public class CombinationSum3 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();

//        boolean[] hasUsed = new boolean[9];
        backtrace(result, tmpList, k, n, 0);
        return result;
    }

    public void backtrace(List<List<Integer>> result, List<Integer> tmpList,
                          int count, int target, int index) {
        if (target < 0 || tmpList.size() > count) return;
        if (target == 0 && tmpList.size() == count) {
            result.add(new ArrayList<>(tmpList));
        }
        for (int i = index; i < 9; i++) {
//            hasUsed[i] = true;
            tmpList.add(i + 1);
            backtrace(result, tmpList, count, target - i -1, i + 1);
//            hasUsed[i] = false;
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new CombinationSum3().combinationSum3(3, 9));
    }
}
