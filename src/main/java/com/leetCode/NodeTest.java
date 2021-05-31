package com.leetCode;

public class NodeTest {


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
//         List list = new ArrayList();
        System.out.println("Hello World!");
        System.out.println("test");


        ListNode list1 = new ListNode(0);// 0 5 17
        ListNode list12 = new ListNode(5);
        ListNode list13 = new ListNode(17);
        list1.next = list12;
        list1.next.next = list13;

        ListNode list2 = new ListNode(2);//2 3 7
        ListNode list22 = new ListNode(3);
        ListNode list23 = new ListNode(7);
        list2.next = list22;
        list2.next.next = list23;

        ListNode listNode = nodeList(list1, list2);
        System.out.println(listNode);


    }

    private static ListNode nodeList(ListNode list1, ListNode list2) {


        ListNode finalResult = new ListNode();
        ListNode result = finalResult;
        if (list1 == null) return list2;
        if (list2 == null) return list1;
       /* if (list1.val < list2.val) {
            result = list1;
        } else {
            result = list2;
        }
        while (list1.next != null && list2.next != null) {
            if (list1.next.val < list2.next.val) {
                result.next = list1.next;
                result = result.next;
                list1 = list1.next;
            } else {
                result.next = list2.next;
                result = result.next;
                list2 = list2.next;
            }
        }*/

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                result.next = list1;
                result = result.next;
                list1 = list1.next;
            } else {
                result.next = list2;
                result = result.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            result.next = list1;
        }
        if (list2 != null) {
            result.next = list2;
        }

        return finalResult.next;
    }
}
