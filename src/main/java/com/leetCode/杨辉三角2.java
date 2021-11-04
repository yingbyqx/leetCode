package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角2 {
    public List<Integer> generate(int numRows) {
        numRows++;
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return new ArrayList<>();
        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(1);
        result.add(tmp1);
        if (numRows == 1) return tmp1;


        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(1);
        tmp2.add(1);
        result.add(tmp2);
        if (numRows == 2) return tmp2;

        for (int i = 2; i < numRows; i++) {
            List<Integer> last = result.get(i - 1);
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < last.size(); j++) {
                if (j == 0 || j == last.size() - 1) {
                    tmp.add(last.get(j));
                }
                if(j != last.size() - 1) {
                    tmp.add(last.get(j) + last.get(j + 1));
                }

            }
            result.add(tmp);
        }
        return result.get(result.size() - 1);
    }

    public static void main(String[] args) {
        System.out.println(new 杨辉三角2().generate(5));
    }
}
