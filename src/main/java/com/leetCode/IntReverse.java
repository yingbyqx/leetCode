package com.leetCode;

/*
给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。

示例 1:

输入: 123
输出: 321

 示例 2:

输入: -123
输出: -321

示例 3:

输入: 120
输出: 21

注意:

假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-integer
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntReverse {

    public int reverse(int x) {//error
        char[] tc;
        if (x < 0) tc = String.valueOf(-x).toCharArray();
        else tc = String.valueOf(x).toCharArray();
        long sum = 0;
        int length = tc.length;
        for (int i = 0; i < length; i++) {
            sum += Integer.parseInt(String.valueOf(tc[length -i -1])) * Math.pow(10, length - i -1);
            if (x >0 && sum > 0x7fffffff) {
                return 0;
            }else  if (x < 0 &&  sum < -0x80000000) {
                return 0;
            }
        }

        if (x < 0) return (int) -sum;
        return (int) sum;
    }

    public int reverse1(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }
}
