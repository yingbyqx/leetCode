package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 *
 * 示例1:
 *
 *  输入：S = "qwe"
 *  输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 *
 * 示例2:
 *
 *  输入：S = "ab"
 *  输出：["ab", "ba"]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-i-lcci
 */
public class Permutation {

    private boolean[] used;
    /**
     如果字符串有重复字母，最简单的去重是使用Set，也可以排序后下标剪枝（相对比较难）
     重复字母的全排列可去做《全排列》系列题目。这道题好像和全排列I差不多。
     接着要做的就是回溯模板啦，选了的跳过，每次选或不选即可爆搜到所有解。
     */
    private List<String> res;
    private int len;

    public String[] permutation(String S) {
        len = S.length();
        used = new boolean[len];
        res = new ArrayList<>();

        dfs(S, new StringBuilder(), 0);

        return res.toArray(new String[0]);
    }

    private void dfs(String s, StringBuilder sb, int cnt) {
        // end —— 当sb长度与s长度一致时结束，存储答案
        if (cnt == len) {
            res.add(sb.toString());
            return;
        }

        // 回溯模板
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                used[i] = true;
                sb.append(s.charAt(i));
                dfs(s, sb, cnt + 1);
                used[i] = false;
                sb.deleteCharAt(cnt);
            }
        }
    }
}
