package main;

import main.utils.Node;

import java.util.HashMap;

/**
 * 复杂链表的复制
 *
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 *
 * @author Guishan Wan
 * @date 2020/4/17 9:47 下午
 */
public class Solution_35 {
    public Node copyRandomList(Node head) {

        HashMap<Node, Node> hashMap = new HashMap<>();

        Node cur = head;
        while (cur != null) {
            hashMap.put(cur, new Node(cur.val));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            hashMap.get(cur).next = hashMap.get(cur.next);
            hashMap.get(cur).random = hashMap.get(cur.random);
            cur = cur.next;
        }
        return hashMap.get(head);
    }
}
