package main;

import main.utils.ListNode;

/**
 * 链表中倒数第k个节点
 *
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 *
 * @author Guishan Wan
 * @date 2020/4/20 10:03 下午
 */
public class Solution_22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }

        ListNode fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }

        ListNode slow = head;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    /**
     * leetcode 19: 删除链表的倒数第N个节点
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        ListNode slow = dummy;
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
