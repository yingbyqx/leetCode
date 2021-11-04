package com.leetCode;

/**
 * 53. 最大子序和
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [-1]
 * 输出：-1
 * <p>
 * 示例 5：
 * <p>
 * 输入：nums = [-100000]
 * 输出：-100000
 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
//        dp[0] = 0;
        dp[0] = nums[0];
        int result = nums[0];
        for (int i = 1; i < length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            if(dp[i] > result){
                result = dp[i];
            }
        }
        return result;
    }
}
