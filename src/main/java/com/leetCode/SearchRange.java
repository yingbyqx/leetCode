package com.leetCode;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * <p>
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
 */
public class SearchRange {

    public int[] searchRange(int[] nums, int target) {
        int [] result = new int[2];

        if(nums.length == 0){
            result[0] = -1;
            result[1] = -1;
            return  result;
        }
        result[0] = findFirst(nums, nums.length, target);
        result[1] = findLast(nums, nums.length, target);
        return result;
    }

    public int findFirst(int [] a, int len, int key)
    {
        if (len < 1)
            return - 1;
        int low = 0;
        int high = len - 1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if (a[mid] == key && (mid - 1 < 0 || a[mid - 1] != key))
            {
                return mid;
            }
            else if (a[mid] >= key)
            {
                high = mid - 1;
            }
            else
            {
                low = mid + 1;
            }
        }
        return -1;
    }
    public int findLast(int [] a, int len, int key)
    {
        if (len < 1)
            return - 1;
        int low = 0;
        int high = len - 1;
        while(low <= high)
        {
            int mid = (low + high)/2;
            if (a[mid] == key && (mid + 1 >= len || a[mid + 1] != key))
            {
                return mid;
            }
            else if (a[mid] <= key)
            {
                low = mid + 1;
            }
            else
            {
                high = mid - 1;
            }
        }
        return -1;
    }
}
