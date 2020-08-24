package com.leetCode;

/**
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 *
 *
 *
 * 示例 1：
 *
 * 输入："abc"
 * 输出：3
 * 解释：三个回文子串: "a", "b", "c"
 *
 * 示例 2：
 *
 * 输入："aaa"
 * 输出：6
 * 解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"
 *
 *
 *
 * 提示：
 *
 *     输入的字符串长度不会超过 1000 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindromic-substrings
 */
public class CountSubstrings {

    public int countSubstrings(String s) {
        int sum = 0;
        char[] ch = s.toCharArray();
        int length = ch.length;
        for (int i = 0; i < length; i++) {
            sum++;
//            System.out.println(ch[i]);
            for (int j = i - 1; j >= 0 && 2 * i - j <length; j--) {
                if (ch[j] == ch[2 * i - j]) {
                    sum++;
//                    System.out.println(s.substring(j, 2*i-j +1));
                } else break;

            }

        }


        for (int i = 0; i < length - 1; i++) {
            if (ch[i] == ch[i + 1]) sum++;
            else continue;
            for (int j = i - 1; j >= 0 && 2 * i + 1 - j <length; j--) {
                if (ch[j] == ch[2 * i + 1 - j]) {
                    sum++;
//                    System.out.println(s.substring(j, 2*i-j +2));
                } else break;

            }

        }

        return sum;
    }
}
