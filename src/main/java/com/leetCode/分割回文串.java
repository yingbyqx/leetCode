package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * <p>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aab"
 * 输出：[["a","a","b"],["aa","b"]]
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "a"
 * 输出：[["a"]]
 */
public class 分割回文串 {

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> tmpList = new ArrayList<>();
        backtrace(result, tmpList, s, 0);
        return result;
    }

    public void backtrace(List<List<String>> result, List<String> tmpList,
                          String s, int index) {
        if (index >= s.length()) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            String seq = s.substring(index, i + 1);
            if (!valid(seq)) continue;
            tmpList.add(seq);
            backtrace(result, tmpList, s, i + 1);
            tmpList.remove(tmpList.size() - 1);
        }

    }

    public boolean valid(String seq) {
        for (int i = 0; i < seq.length() / 2; i++) {
            if (seq.charAt(i) != seq.charAt(seq.length() - i - 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new 分割回文串().partition("b"));
        System.out.println(new 分割回文串().partition("aab"));
    }
}
