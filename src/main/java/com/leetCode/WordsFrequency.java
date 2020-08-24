package com.leetCode;

import java.util.HashMap;
import java.util.Map;

public class WordsFrequency {


    private Map<String, Integer> map = new HashMap<>();

    public WordsFrequency(String[] book) {
        for (String s : book) {
            map.merge(s, 1, Integer::sum);
        }

    }

    public int get(String word) {
        return map.get(word) == null ? 0 : map.get(word);
    }

    public static void main(String[] args) {
        WordsFrequency wordsFrequency = new WordsFrequency(new String[]{"i", "have", "an", "apple", "he", "have", "a", "pen"});
        System.out.println(wordsFrequency.get("you"));
        System.out.println(wordsFrequency.get("have"));
        System.out.println(wordsFrequency.get("apple"));
        System.out.println(wordsFrequency.get("pen"));
    }
}
