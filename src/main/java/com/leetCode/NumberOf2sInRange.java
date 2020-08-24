package com.leetCode;

/**
 * 编写一个方法，计算从 0 到 n (含 n) 中数字 2 出现的次数。
 *
 * 示例:
 *
 * 输入: 25
 * 输出: 9
 * 解释: (2, 12, 20, 21, 22, 23, 24, 25)(注意 22 应该算作两次)
 *
 * 提示：
 *
 *     n <= 10^9
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-2s-in-range-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class NumberOf2sInRange {

    public int numberOf2sInRange(int n) {

        int base = 1, count = 0;

        while (base <= n) {

            int right = n % base;
            int left = n / base / 10;
            int mid = n / base % 10;

            // judge left side
            count += left * base;

            // judge right side
            if (mid == 2)
                count += right + 1;
            else if (mid > 2)
                count += base;

            base *= 10;
        }

        return count;
    }
}
