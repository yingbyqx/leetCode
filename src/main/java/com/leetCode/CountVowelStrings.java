package com.leetCode;

import java.util.ArrayList;
import java.util.List;

/**
 * 1641. 统计字典序元音字符串的数目
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * <p>
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * <p>
 * 示例 3：
 * <p>
 * 输入：n = 33
 * 输出：66045
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-sorted-vowel-strings
 */
public class CountVowelStrings {

    public int countVowelStrings(int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrace(result, new ArrayList<>(), 0, n);
        System.out.println(result);
        return result.size();
    }

    public void backtrace(List<List<Integer>> result, List<Integer> tmpList,
                          int index, int target) {
        int[] vowel = {1, 2, 3, 4, 5};
        if (tmpList.size() == target) {
            result.add(new ArrayList<>(tmpList));
            return;
        }
        for (int i = index; i < vowel.length; i++) {
            if (tmpList.size() > 0 && tmpList.get(tmpList.size() - 1) > vowel[i]) {
               continue;
            }
            tmpList.add(vowel[i]);

            backtrace(result, tmpList, index, target);
            tmpList.remove(tmpList.size() - 1);
        }

    }

    public static void main(String[] args) {
        System.out.println(new CountVowelStrings().countVowelStrings(5));
    }
}
