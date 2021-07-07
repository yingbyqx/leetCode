package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 * <p>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [0]
 * 输出：[[],[0]]
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 10
 * -10 <= nums[i] <= 10
 * nums 中的所有元素 互不相同
 */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrace(result, new ArrayList<Integer>(), nums, used);
        return result;
    }

    private void backtrace(List<List<Integer>> result, List<Integer> tmpList,
                           int[] nums, boolean[] used) {
        result.add(new ArrayList<>(tmpList));
        for (int i = 0; i < nums.length && !used[i]; i++) {
            used[i] = true;
            tmpList.add(nums[i]);
            backtrace(result, tmpList, nums, used);
            used[i] = false;
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Subsets().subsets(new int[]{1,2,3}));
        System.out.println(new Subsets().subsets(new int[]{1}));
    }
}
