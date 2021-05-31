package com.leetCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 *
 *
 *
 * 示例 1:
 *
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 *
 * 示例 2:
 *
 * 输入: nums = [1], k = 1
 * 输出: [1]
 *
 *
 *
 * 提示：
 *
 *     你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
 *     你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 *     题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
 *     你可以按任意顺序返回答案。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 */
public class TopKFrequent {

    public int[] topKFrequent(int[] nums, int k) {
        int [] res = new int [k];
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        /*int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getValue() >= k){
                res[index] = entry.getKey();
                index ++;
            }
        }*/

        Iterator<Map.Entry<Integer, Integer>> entries = map.entrySet().iterator();
        // 新建最大堆
        Queue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>((v1, v2) -> v2.getValue() - v1.getValue());
        while (entries.hasNext()){
            queue.offer(entries.next());
        }
        //
        for (int i=0; i<k; i++){
            Map.Entry<Integer,Integer> currentEntry = queue.poll();
            res[i] = currentEntry.getKey();
        }

        return res;
    }

    public static void main(String[] args) {
        String s = "ee.jsp";
        System.out.println(s.split("\\."));
    }
}
