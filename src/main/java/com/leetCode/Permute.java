package com.leetCode;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列 回溯
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Permute {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};
        System.out.println(permute1(nums));

    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            for (int j = nums.length - i; j < nums.length; j++) {
                List<List<Integer>> tmpList = new ArrayList<>();
                for (List<Integer> integers : result) {
                    List<Integer> tmp = new ArrayList<>(integers);
                    tmp.add(nums[j]);
                    tmpList.add(tmp);
                }
                if (result.isEmpty()) {
                    List<Integer> tmp = new ArrayList<>(nums[j]);
                    tmpList.add(tmp);
                }
                result.addAll(tmpList);
            }
        }
        for (int num : nums) {
            List<List<Integer>> tmpList = new ArrayList<>();
            for (List<Integer> integers : result) {
                List<Integer> tmp = new ArrayList<>(integers);
                tmp.add(num);
                tmpList.add(tmp);
            }
            if (result.isEmpty()) {
                List<Integer> tmp = new ArrayList<>(num);
                tmpList.add(tmp);
            }
            result.addAll(tmpList);
        }
        return result;
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<Integer>();
        int[] marks = new int[nums.length];
        backTrace(result, tmpList, nums, marks);
        return result;
    }

    public static void backTrace(List<List<Integer>> result, List<Integer> tmpList,
                                 int[] nums, int[] marks) {
        if (tmpList.size() == nums.length) {
            result.add(new ArrayList<>(tmpList));
        }

        for (int i = 0; i < nums.length; i++) {
            if (marks[i] == 1) continue;
            marks[i] = 1;
            tmpList.add(nums[i]);
            backTrace(result, tmpList, nums, marks);

            marks[i] = 0;
            tmpList.remove(tmpList.size() - 1);//todo
        }


    }
}
// @lc code=end

