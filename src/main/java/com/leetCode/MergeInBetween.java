package com.leetCode;

/** 1669. 合并两个链表
 * 给你两个链表 list1 和 list2 ，它们包含的元素分别为 n 个和 m 个。
 *
 * 请你将 list1 中第 a 个节点到第 b 个节点删除，并将list2 接在被删除节点的位置。
 *
 * 下图中蓝色边和节点展示了操作后的结果：
 *
 * 请你返回结果链表的头指针。
 *
 *
 *
 * 示例 1：
 *
 * 输入：list1 = [0,1,2,3,4,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
 * 输出：[0,1,2,1000000,1000001,1000002,5]
 * 解释：我们删除 list1 中第三和第四个节点，并将 list2 接在该位置。上图中蓝色的边和节点为答案链表。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/merge-in-between-linked-lists
 */
public class MergeInBetween {

    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode tmp1 = list1;
        ListNode tmp2 = list1;
        for (int i = 1; i < a; i++) {
            tmp1 = tmp1.next;
            tmp2 = tmp2.next;
        }
        for (int i = 1; i <= b - a + 2; i++) {
            tmp2 = tmp2.next;
        }
        ListNode tmp3 = list2;
        while (tmp3.next != null){
            tmp3 = tmp3.next;
        }
        tmp3.next = tmp2;
        tmp1.next = list2;
        return list1;
    }

    public static void main(String[] args) {
        ListNode list6 = new ListNode(5);
        ListNode list5 = new ListNode(4);
        list5.next = list6;
        ListNode list4 = new ListNode(3);
        list4.next = list5;
        ListNode list3 = new ListNode(2);
        list3.next = list4;
        ListNode list2 = new ListNode(1);
        list2.next = list3;
        ListNode list1 = new ListNode(0);
        list1.next = list2;


        ListNode list23 = new ListNode(100);
        ListNode list22 = new ListNode(101);
        list22.next = list23;
        ListNode list21 = new ListNode(102);
        list21.next = list22;

        ListNode result = new MergeInBetween().mergeInBetween(list1, 3, 4, list21);
        System.out.println(result);
    }
}
