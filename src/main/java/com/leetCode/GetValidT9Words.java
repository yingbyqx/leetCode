package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetValidT9Words {

    private static Map<Integer, String> dictMap = new HashMap<>();

    static {
        dictMap.put(2, "abc");
        dictMap.put(3, "def");
        dictMap.put(4, "ghi");
        dictMap.put(5, "jkl");
        dictMap.put(6, "mno");
        dictMap.put(7, "pqrs");
        dictMap.put(8, "tvu");
        dictMap.put(9, "wxyz");
    }

    public List<String> getValidT9Words(String num, String[] words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (word == null || word.length() != num.length()) break;
            boolean check = true;
            for (int i = 0; i < word.toCharArray().length; i++) {
                String s = dictMap.get(Integer.parseInt("" + num.charAt(i)));
                if (s == null) {
                    check = false;
                    break;
                }
                if (!s.contains("" + word.charAt(i))) {
                    check = false;
                    break;
                }
            }
            if (check) result.add(word);
        }

        return result;
    }


    public static void main(String[] args) {
        GetValidT9Words getValidT9Words = new GetValidT9Words();
        System.out.println(getValidT9Words.getValidT9Words("8733", new String[]{"tree", "used"}));
        System.out.println(getValidT9Words.getValidT9Words("2", new String[]{"a", "b", "c", "d"}));

    }

}
