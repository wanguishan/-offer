package main;

import main.utils.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 从尾到头打印链表
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 *
 * @author wanguishan
 * @date 2019年12月4日15:21:43
 */
public class Solution_6 {
    // 方法一：栈
    // 栈具有后进先出的特点，在遍历链表时将值按顺序放入栈中，最后出栈的顺序即为逆序
    public static ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack = new Stack<>();
        while (listNode != null) {
            stack.add(listNode.val);
            listNode = listNode.next;
        }
        ArrayList<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            result.add(stack.pop());
        }
        return result;
    }

    // 方法二：递归
    public static ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode != null) {
            result.addAll(printListFromTailToHead2(listNode.next));
            result.add(listNode.val);
        }
        return result;
    }

    // 方法三：头插法
    public static ArrayList<Integer> printListFromTailToHead3(ListNode listNode) {
        // 头插法反转链表
        ListNode head = new ListNode(-1);
        while (listNode != null) {
            ListNode temp = listNode.next;
            listNode.next = head.next;
            head.next = listNode;
            listNode = temp;
        }

        ArrayList<Integer> result = new ArrayList<>();
        head = head.next;
        while (head != null) {
            result.add(head.val);
            head = head.next;
        }
        return result;
    }

}


