package com.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 给定两个整数数组，请交换一对数值（每个数组中取一个数值），使得两个数组所有元素的和相等。
 *
 * 返回一个数组，第一个元素是第一个数组中要交换的元素，第二个元素是第二个数组中要交换的元素。若有多个答案，返回任意一个均可。若无满足条件的数值，返回空数组。
 *
 * 示例:
 *
 * 输入: array1 = [4, 1, 2, 1, 1, 2], array2 = [3, 6, 3, 3]
 * 输出: [1, 3]
 *
 * 示例:
 *
 * 输入: array1 = [1, 2, 3], array2 = [4, 5, 6]
 * 输出: []
 *
 * 提示：
 *
 *     1 <= array1.length, array2.length <= 100000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sum-swap-lcci
 */
public class FindSwapValues {

    public int[] findSwapValues(int[] array1, int[] array2) {
        Set<Integer> set = new HashSet<>();
        int sum1 = 0, sum2 =0;
        for(int i : array1){
            sum1 += i;
        }
        for(int i : array2){
            sum2 += i;
            set.add(i);
        }
        int dis = sum1 - sum2;
        if(dis % 2 != 0){
            return new int[]{};
        }
        for(int i : array1){
            if(set.contains(i - dis / 2)){
                return new int[]{i, i - dis / 2};
            }
        }
        return new int[]{};
    }
}
