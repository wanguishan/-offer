package main;

import main.utils.ListNode;

/**
 * 两个链表的第一个公共节点
 *
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * @author Guishan Wan
 * @date 2020/4/17 1:28 下午
 */
public class Solution_52 {
    /**
     * 巧妙解法：利用两个链表结点和相等
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pHeadA = headA;
        ListNode pHeadB = headB;
        while (pHeadA != pHeadB) {
            if (pHeadA != null) {
                pHeadA = pHeadA.next;
            } else {
                pHeadA = headB;
            }

            if (pHeadB != null) {
                pHeadB = pHeadB.next;
            } else {
                pHeadB = headA;
            }
        }
        return pHeadA;
    }

    /**
     * 解法二： 遍历求出两条链表长度，计算长度差diff，让长的链表先走diff个节点，然后再同时遍历直到相遇
     *
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        int lengthOfA = getLength(headA);
        int lengthOfB = getLength(headB);

        ListNode headLong;
        ListNode headShort;
        if (lengthOfA > lengthOfB) {
            headLong = headA;
            headShort = headB;
        } else {
            headLong = headB;
            headShort = headA;
        }

        int diff = lengthOfA > lengthOfB ? lengthOfA - lengthOfB : lengthOfB - lengthOfA;
        for (int i = 0; i < diff; i++) {
            headLong = headLong.next;
        }
        while (headLong != null && headShort != null && headLong != headShort) {
            headLong = headLong.next;
            headShort = headShort.next;
        }
        return headLong;
    }

    private int getLength(ListNode pHead) {
        int length = 0;
        ListNode temp = pHead;
        while (temp != null) {
            temp = temp.next;
            length++;
        }
        return length;
    }
}
