package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 *
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [1,2,2]
 * 输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
 *
 * 示例 2：
 *
 * 输入：nums = [0]
 * 输出：[[],[0]]
 *
 *
 *
 * 提示：
 *
 *     1 <= nums.length <= 10
 *     -10 <= nums[i] <= 10
 */
public class SubsetsWithDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        Arrays.sort(nums);
        backtrace(result, tmp, nums, 0);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> tmp,
                           int[] nums, int index) {

        result.add(new ArrayList<>(tmp));
        for (int i = index; i < nums.length; i++) {
            tmp.add(nums[i]);
            backtrace(result, tmp, nums, i + 1);
            tmp.remove(tmp.size() - 1);
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
    }

    public static void main(String[] args) {
        SubsetsWithDup dup = new SubsetsWithDup();
        System.out.println(dup.subsetsWithDup(new int[]{1,2,2}));
        System.out.println(dup.subsetsWithDup(new int[]{0}));
    }
}
