package com.leetCode;

import java.util.ArrayList;
import java.util.List;

public class 杨辉三角 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) return result;
        List<Integer> tmp1 = new ArrayList<>();
        tmp1.add(1);
        result.add(tmp1);
        if (numRows == 1) return result;


        List<Integer> tmp2 = new ArrayList<>();
        tmp2.add(1);
        tmp2.add(1);
        result.add(tmp2);
        if (numRows == 2) return result;

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
        return result;
    }
}
