package com.leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ShortestSeq {


    public int[] shortestSeq(int[] big, int[] small) {

        int first = 0;
        int last =0;
        HashMap<Integer, Integer> map = new HashMap();

        for (int key:small){
            map.put(key, map.getOrDefault(key, 0) -1);
        }

        int count = small.length;


        int left =0;
        int right = 0;
        int minLen =Integer.MAX_VALUE;
        while(left <= right && right < big.length) {
            map.put(big[right], map.getOrDefault(big[right], 0) +1);

            if (map.get(big[right]) <= 0) {
                count--;
            }

            while(left < right && map.get(big[left]) > 0 ) {
                map.put(big[left], map.getOrDefault(big[left], 0) -1);
                left++;
            }

            if (count == 0 && (right-left +1) < minLen) {
                first = left;
                last  = right;
                minLen = right-left +1;
            }

            right++;

        }

        return minLen ==Integer.MAX_VALUE?new int[]{}:new int[]{first,last};
    }


    public int[] shortestSeq1(int[] big, int[] small) {

        int[] res = new int[2];
        int start = 0;
        HashSet<Integer> tmpSet = new HashSet<Integer>();
        for (int i : small) {
            tmpSet.add(i);
        }
        while (start < big.length) {
            int[] tmp = new int[0];
            try {
                tmp = dealShortestSeq(big, (HashSet<Integer>) tmpSet.clone(), start);
            } catch (Exception e) {
                return new int[0];
            }
            start = tmp[1];
            if (tmp[2] == 0) {
                return res;
            }
            if (res[1] == 0 || tmp[2] - tmp[0] < res[1] - res[0]) {
                res[0] = tmp[0];
                res[1] = tmp[2];
            }
            if (tmp[2] == big.length - 1 || (tmp[1] == tmp[0])) {
                return res;
            }
        }


        return res;
    }

    public int[] dealShortestSeq(int[] big, Set<Integer> small, int start) throws Exception {

        int[] res = new int[3];
        res[0] = start;
        int contains = 0;
        for (int i = start; i < big.length; i++) {
            if (small.contains(big[i])) {
                contains++;
                if (contains == 1) {
                    res[0] = i;
                }
                if (contains == 2) {
                    res[1] = i;
                }
                small.remove(big[i]);
                if (small.isEmpty()) {
                    res[2] = i;
                     return res;
                }
            }
        }
        if (start == 0){
            throw new Exception();
        }

        return res;
    }

    public static void main(String[] args) {
        ShortestSeq shortestSeq = new ShortestSeq();
        System.out.println(Arrays.toString(shortestSeq.shortestSeq(new int[]{1,2,3},
                new int[]{4})));
        System.out.println(Arrays.toString(shortestSeq.shortestSeq(new int[]{1,2,3},
                new int[]{2})));
        System.out.println(Arrays.toString(shortestSeq.shortestSeq(new int[]{7, 5, 9, 0, 2, 1, 3, 5, 7, 9, 1, 1, 5, 8, 8, 9, 7},
                new int[]{1, 5, 9})));

        System.out.println(Arrays.toString(shortestSeq.shortestSeq(new int[]{521704, 897261, 279103, 381783, 668374, 934085, 254258, 726184, 496153, 804155},
                new int[]{897261, 934085, 381783, 496153})));
    }
}
