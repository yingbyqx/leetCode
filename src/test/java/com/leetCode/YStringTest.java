package com.leetCode;

import java.util.Arrays;

public class YStringTest {

    public static void main(String[] args) {
        String a = "ying.ying%ying";
        a = a.replace(".", "\\.");
        a = a.replace("%", "\\%");
        System.out.println(a);///^\/(?:[^/]+\/)*$/

        String b = "/bigscreen/#/screen";
        System.out.println(b.contains("#"));
        String[] split = b.split("#");
        System.out.println(Arrays.toString(split));
    }
}
