package main;

import main.utils.ListNode;

import java.util.Stack;

/**
 * 反转链表
 *
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author Guishan Wan
 * @date 2020/4/20 6:57 下午
 */
public class Solution_24 {

    /**
     * 方法一：头插法
     */
    public ListNode reverseList_1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // 初始设定
        ListNode pre = null;
        ListNode cur = head;
        // 终止条件
        while (cur != null) {
            // 第一步：暂存
            ListNode temp = cur.next;
            // 第二步：指向
            cur.next = pre;
            // 第三步：归位（先pre，后cur）
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    /**
     * 方法二：递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList_2(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // 遍历到链表尾部
        ListNode newHead = reverseList_2(head.next);
        // 关键：反转
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    /**
     * 方法三：栈 (不推荐)
     *
     */
    public ListNode reverseList_3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null) {
            stack.push(head);
            head = head.next;
        }
        ListNode cur = stack.pop();
        ListNode dummy = cur;

        while (!stack.isEmpty()) {
            cur.next = stack.pop();
            cur = cur.next;
        }
        cur.next = null;
        return dummy;
    }
}

