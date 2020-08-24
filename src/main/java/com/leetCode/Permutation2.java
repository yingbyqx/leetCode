package com.leetCode;

import java.util.HashSet;
import java.util.Set;

/**
 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。

 示例1:

 输入：S = "qqe"
 输出：["eqq","qeq","qqe"]

 示例2:

 输入：S = "ab"
 输出：["ab", "ba"]

 提示:

 字符都是英文字母。
 字符串长度在[1, 9]之间。

 来源：力扣（LeetCode）
 链接：https://leetcode-cn.com/problems/permutation-ii-lcci
 */
public class Permutation2 {

    private boolean[] used;

    private Set<String> res;
    private int len;

    public String[] permutation(String S) {
        len = S.length();
        used = new boolean[len];
        res = new HashSet<>();

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
