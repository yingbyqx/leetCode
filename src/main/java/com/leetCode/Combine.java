package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
 * <p>
 * 示例:
 * <p>
 * 输入: n = 4, k = 2
 * 输出:
 * [
 * [2,4],
 * [3,4],
 * [2,3],
 * [1,2],
 * [1,3],
 * [1,4],
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combinations
 */
public class Combine {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] hasUsed = new boolean[n];
        backtrace(result, new ArrayList<>(), n, 1, k);
        return result;
    }

    public void backtrace(List<List<Integer>> result, List<Integer> tmpList,
                          int n, int index, int target) {
        if (tmpList.size() == target) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = index; i < n + 1; i++) {
//            hasUsed[i - 1] = true;
            tmpList.add(i);
            backtrace(result, tmpList, n,  i + 1, target);
            tmpList.remove(tmpList.size() - 1);
//            hasUsed[i - 1] = false;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Combine().combine(4, 2));
    }
}
