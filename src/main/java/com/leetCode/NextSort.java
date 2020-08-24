package com.leetCode;

import java.util.Arrays;

/*
实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

必须原地修改，只允许使用额外常数空间。

以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/next-permutation
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NextSort {

    public void nextPermutation(int[] nums) {
        int c;
        boolean flag = false;
        int min = 0;
        int tmp = 0;
        breakFlag:
        for (int i = nums.length -2; i >= 0; i--) {
            for (int j = nums.length -1; j > i; j--) {
                //获取范围内大于nums[i] 的最小值
                if(nums[j] > nums[i] && (nums[j] < tmp || min == 0)){
                    min = j;
                    tmp = nums[j];
                }
                if(nums[i] < tmp){
                    c = nums[i];
                    nums[j] = c;
                    nums[i] = tmp;
                    flag = true;
                    // 剩下的从小到大排列
                    sort(nums, i +1, nums.length -1);
                    break breakFlag;
                }
            }
        }

        if(!flag) sort(nums, 0, nums.length -1);
        System.out.println(Arrays.toString(nums));

    }

    private void sort(int[] nums, int begin, int end) {
        int c;
        for (int i = end; i >= begin + 1; i--) {
            for (int j = i -1; j >= begin; j--) {
                if(nums[i] < nums[j]){
                    c = nums[j];
                    nums[j] = nums[i];
                    nums[i] = c;
                }
            }
        }
    }

}
