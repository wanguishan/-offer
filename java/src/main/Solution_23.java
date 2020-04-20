package main;

import main.utils.ListNode;

import java.util.HashSet;

/**
 * 链表中环的入口节点
 *
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 *
 * @author Guishan Wan
 * @date 2020/4/20 8:44 下午
 */
public class Solution_23 {

    /**
     * 双指针（快、慢指针）
     *
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode slow = pHead;
        ListNode fast = pHead;

        do {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        slow = pHead;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 判断链表是否有环：快慢指针
     *
     * @param pHead
     * @return
     */
    public boolean hasCycle_1(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return false;
        }

        ListNode slow = pHead;
        ListNode fast = pHead;

        do {
            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        } while (fast != slow);

        return true;
    }

    /**
     * 判断链表是否有环：HashSet存ListNode
     *
     * @param pHead
     * @return
     */
    public boolean hasCycle_2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return false;
        }

        HashSet<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        while (cur != null) {
            if (set.contains(cur)) {
                return true;
            } else {
                set.add(cur);
            }
            cur = cur.next;
        }
        return false;
    }
}

