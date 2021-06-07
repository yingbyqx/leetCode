package com.leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1833. 雪糕的最大数量
 * 夏日炎炎，小男孩 Tony 想买一些雪糕消消暑。
 * <p>
 * 商店中新到 n 支雪糕，用长度为 n 的数组 costs 表示雪糕的定价，其中 costs[i] 表示第 i 支雪糕的现金价格。Tony 一共有 coins 现金可以用于消费，他想要买尽可能多的雪糕。
 * <p>
 * 给你价格数组 costs 和现金量 coins ，请你计算并返回 Tony 用 coins 现金能够买到的雪糕的 最大数量 。
 * <p>
 * 注意：Tony 可以按任意顺序购买雪糕。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：costs = [1,3,2,4,1], coins = 7
 * 输出：4
 * 解释：Tony 可以买下标为 0、1、2、4 的雪糕，总价为 1 + 3 + 2 + 1 = 7
 * <p>
 * 示例 2：
 * <p>
 * 输入：costs = [10,6,8,7,7,8], coins = 5
 * 输出：0
 * 解释：Tony 没有足够的钱买任何一支雪糕。
 * <p>
 * 示例 3：
 * <p>
 * 输入：costs = [1,6,3,1,2,5], coins = 20
 * 输出：6
 * 解释：Tony 可以买下所有的雪糕，总价为 1 + 6 + 3 + 1 + 2 + 5 = 18
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/maximum-ice-cream-bars
 */
public class 雪糕的最大数量 {

    public static void main(String[] args) {
        int[] costs = {7,3,3,6,6,6,10,5,9,2};
        int coins = 56;
        int maxIceCream = maxIceCream(costs, coins);
        System.out.println(maxIceCream);
        System.out.println(maxIceCream1(costs, coins));
    }


    public static int maxIceCream1(int[] costs, int coins) {

        Arrays.sort(costs);
        for (int i = 0; i < costs.length; i++) {
            coins -= costs[i];
            if(coins == 0) return i +1;
            if(coins < 0) return i;
        }
        return costs.length;
    }

    public static int maxIceCream(int[] costs, int coins) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> tmpList = new ArrayList<>();
        Arrays.sort(costs);
        int maxCount = backtrace(result, tmpList, costs, coins, 0, 0);
        System.out.println(result);
        return maxCount;
    }

    public static int backtrace(List<List<Integer>> result, List<Integer> tmpList,
                                int[] costs, int coins, int index, int maxCount) {
        if (coins < 0) {
            ArrayList<Integer> tResult = new ArrayList<>(tmpList);
            tResult.remove(tResult.size() - 1);
            result.add(tResult);
            return Math.max(maxCount, tResult.size());
        }
        if (coins == 0 || tmpList.size() == costs.length) {
            result.add(new ArrayList<>(tmpList));
            return Math.max(maxCount, tmpList.size());
        }
        if(!tmpList.isEmpty()) result.add(new ArrayList<>(tmpList));

        for (int i = index; i < costs.length; i++) {
            tmpList.add(costs[i]);
            maxCount = backtrace(result, tmpList, costs, coins - costs[i], i + 1, maxCount);
            tmpList.remove(tmpList.size() - 1);
            while (i < costs.length -1 && costs[i] == costs[i+1]) i++;
        }
        return Math.max(maxCount, tmpList.size());
    }
}
