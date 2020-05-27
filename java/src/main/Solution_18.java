package main;

import main.utils.ListNode;

/**
 * 删除链表的节点
 *
 * @author Guishan Wan
 * @date 2020/4/2 7:38 下午
 */
public class Solution_18 {

    /**
     * 给定单向链表的一个节点指针，定义一个函数在O(1)时间删除该节点
     *
     * @param pHead
     * @param targetNode
     */
    public static void deleteNode(ListNode pHead, ListNode targetNode) {
        if (pHead == null || targetNode == null) {
            return;
        }

        // 要删除的节点是尾节点
        if (targetNode.next == null) {
            ListNode cur = pHead;
            if (cur == targetNode) {        // 链表中只有一个节点，删除该节点是应该同时将指向它的引用都置为null
                targetNode = null;
                pHead = null;
                cur = null;
            } else {                                // 链表中有多个节点
                while (cur != null && cur.next != targetNode) {
                    cur = cur.next;
                }
                if (cur != null) {
                    cur.next = cur.next.next;
                    targetNode.next = null;
                } else {                            // 要删除的节点不在链表中
                    return;
                }
            }
        } else {                                    // 要删除的节点不是尾节点
            // targetNode的后继节点
            ListNode nextOfTargetNode = targetNode.next;

            // 将targetNode的后继节点的值复制到targetNode中
            // 此时targetNode的值和他后继节点的值相等，所以删除targetNode的后继节点等价于删除targetNode
            targetNode.val = nextOfTargetNode.val;
            // 删除targetNode的后继节点
            targetNode.next = nextOfTargetNode.next;
            nextOfTargetNode.next = null;
        }
    }

    /**
     * leetcode 82: 删除链表中重复的节点-重复节点不保留（递归法）
     * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        if (pHead.val == pHead.next.val) {  // 当前节点是重复节点
            while (pHead.next != null && pHead.next.val == pHead.val) {
                // 跳过值与当前节点相同的全部节点，找到第一个与当前节点不同的节点
                pHead.next = pHead.next.next;
            }
            return deleteDuplication(pHead.next); // 从第一个与当前节点不同的节点继续递归
        } else {
            pHead.next = deleteDuplication(pHead.next); // 保留当前节点，从下一个节点继续递归
            return pHead;
        }
    }

    /**
     * 非递归(双指针)
     */
    public ListNode deleteDuplication_2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = pHead;

        ListNode cur = pHead;
        ListNode pre = dummy;

        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur = cur.next;
            }
            cur = cur.next;

            if (pre.next.next == cur) { // 根据pre和cur之间的间隔是否为1来判断中间是否有重复节点
                pre = pre.next;
            } else {
                pre.next = cur;
            }
        }
        return dummy.next;
    }
}

/**
 * leetcode 83: 删除排序链表中的重复元素-重复节点保留一个
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。
 */
class DeleteDuplicates {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}

/**
 * leetcode:203 删除链表的节点(根据值删除节点，并返回头节点)
 */
class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;

        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    /**
     * 双指针写法
     */
    public ListNode deleteNode_2(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur = head;
        ListNode pre = dummy;

        while (cur != null) {
            // 第一种情况，cur当前的值是val，则cur继续向前，pre来删除
            if (cur.val == val) {
                cur = cur.next;
                pre.next = cur;
            } else {
                // 第二种情况，cur和pre都向前移动一个结点
                cur = cur.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}
