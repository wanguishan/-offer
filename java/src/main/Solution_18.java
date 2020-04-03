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
            ListNode currentNode = pHead;
            if (currentNode == targetNode) {        // 链表中只有一个节点，删除该节点是应该同时将指向它的引用都置为null
                targetNode = null;
                pHead = null;
                currentNode = null;
            } else {                                // 链表中有多个节点
                while (currentNode != null && currentNode.next != targetNode) {
                    currentNode = currentNode.next;
                }
                if (currentNode != null) {
                    currentNode.next = currentNode.next.next;
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
     * 删除链表中重复的节点（递归法）
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
            ListNode node = pHead.next;
            while (node != null && node.val == pHead.val) {
                // 跳过值与当前节点相同的全部节点，找到第一个与当前节点不同的节点
                node = node.next;
            }
            return deleteDuplication(node); // 从第一个与当前节点不同的节点继续递归
        } else {
            pHead.next = deleteDuplication(pHead.next); // 保留当前节点，从下一个节点继续递归
            return pHead;
        }
    }

    /**
     * 非递归
     * pre始终指向下一个不重复的节点
     *
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication_2(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode pre = null, cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                if (pre == null) {
                    pHead = cur.next;
                } else {
                    pre.next = cur.next;
                }
            } else {
                pre = cur;
            }
            cur = cur.next;
        }
        return pHead;
    }

}
