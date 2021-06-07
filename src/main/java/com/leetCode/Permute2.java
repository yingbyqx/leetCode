package com.leetCode;
/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [47] 全排列 回溯
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 输入：nums = [1,1,2]
  输出：
 [[1,1,2],
 [1,2,1],
 [2,1,1]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// @lc code=start
class Permute2 {

    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        System.out.println(permute(nums));

        nums = new int[]{1, 1, 3};

        System.out.println(permute(nums));

    }



    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> tmpList = new ArrayList<Integer>();
        Arrays.sort(nums);
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
            while (i < nums.length-1 && nums[i] == nums[i+1]) i++;
            tmpList.remove(tmpList.size() - 1);//todo
        }


    }
}
// @lc code=end

