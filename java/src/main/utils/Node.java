package main.utils;

/**
 * 复杂链表的结点定义类（题35）
 *
 * @author Guishan Wan
 * @date 2020/4/17 9:49 下午
 */
public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
