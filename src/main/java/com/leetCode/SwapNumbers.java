package com.leetCode;

import java.util.Arrays;

public class SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] + numbers[1];
        numbers[1] = numbers[0] - numbers[1];
        numbers[0] = numbers[0] - numbers[1];
        return numbers;
    }

    public static void main(String[] args) {
        SwapNumbers swapNumbers = new SwapNumbers();
        System.out.println(Arrays.toString(swapNumbers.swapNumbers(new int[]{1, 2})));
    }
}
