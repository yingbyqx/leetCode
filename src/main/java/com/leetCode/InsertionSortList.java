package com.leetCode;

/**
 * 147. 对链表进行插入排序
 *
 * 对链表进行插入排序。
 *
 *
 * 插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
 * 每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。
 *
 *
 *
 * 插入排序算法：
 *
 *     插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
 *     每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
 *     重复直到所有输入数据插入完为止。
 *
 *
 *
 * 示例 1：
 *
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 *
 * 示例 2：
 *
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 */
public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        ListNode tmpNode;

        ListNode first = head;
        if(first.next == null) return head;
        ListNode second = head.next;
        if(second.val < first.val){
            ListNode tmp = second;
            second = first;
            first = tmp;
        }

        ListNode remainNode = second;

        while (remainNode.next != null){
            remainNode = remainNode.next;
            ListNode tFirst = first;
            ListNode tSecond = second;
            if(remainNode.val < tFirst.val){
                ListNode tmp = remainNode.next;
//                ListNode tmpFirst = tFirst;
                tFirst = remainNode;
                remainNode.next = tFirst;
                tFirst.next = tmp;
                tSecond = tFirst;
                break;
            }
            while (tSecond != null){
                if(remainNode.val < tSecond.val){
                    ListNode tmp = remainNode.next;
                    tFirst.next = remainNode;
                    remainNode.next = tSecond;
                    tSecond.next = tmp;
                    break;
                }
                tFirst = tSecond;
                tSecond = tSecond.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        System.out.println();
    }
}
