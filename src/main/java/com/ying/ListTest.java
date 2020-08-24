package com.ying;

import java.util.Arrays;

///* 题目2：
//给定一个数组array，如[23, 27, 33, 45, ....]；
//给定一个常数y(已知： y <= sum(array))，如： 5；
//求解： 将常数y按照比率 23: 27:33: 45:...（比率越接近越好）将 y 分解，获得每一个占比的值是多少。
//
//要求数组array的每一个数（如：第一个数23）分解获得的值不能比当前值大（23）；
//要求分解获得每一个值必须为整数；
//
//举例子：
//array = [20, 30, 50]
//y = 10
//则： result = [2, 3, 5] 111111111111
//*/
public class ListTest {

    public static void main(String[] args) {
        int[] result = new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(Arrays.toString(test(result, 8)));

        System.out.println(Arrays.toString(test(new int[]{20, 30, 51}, 10)));
    }

    public static int[] test(int[] oriArray, int y){
        // oriArray 有序 若无序就排一下序  省略。。。。。
        double total = 0;
        int tempTotal = 0;
        int size = oriArray.length;
        for (int i : oriArray) {
            total += i;
        }
        int[] result = new int[size];
        int add = 0;
        int min = 0;
        for (int i = 0; i < size - 1; i++) {
            double temp = y / total * oriArray[i];
            /*if(temp - (int) (temp + 0.5) >= 0.5){
                add ++;
            }else {
                min ++;
            }*/
            if(y == tempTotal){
                result[i] = 0;
            }else {
                result[i] = (int) (temp + 0.5);
            }

            tempTotal += result[i];
        }

        result[size -1] = y - tempTotal;
        return result;
    }


}
