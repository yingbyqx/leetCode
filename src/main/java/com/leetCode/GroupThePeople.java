package com.leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupThePeople {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            List<Integer> has = map.get(groupSize);
            if (has == null) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(groupSize, tmp);
            } else {
                has.add(i);

            }
            if (map.get(groupSize).size() == groupSize) {
                result.add(map.get(groupSize));
                map.remove(groupSize);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(new GroupThePeople().groupThePeople(new int[]{3,3,3,3,3,1,3}));
    }
}
