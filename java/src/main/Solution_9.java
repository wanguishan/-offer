package main;

import java.util.Stack;

/**
 * 用两个栈实现队列
 * 完成队列的Push和Pop操作，队列中的元素为int类型
 * <p>
 * 解题思路：
 * 有两个栈stack1，stack2，stack1为入栈，stack2为出栈。
 * 入栈时，直接进入stack1即可；
 * 出栈时，先判断stack2栈是否为空：
 * 如果不是空栈，直接pop()；如果是空栈，先将stack1中所有元素倒压在stack2里面，再pop()stack2中最上面（后面）的元素。
 *
 * @author wanguishan
 * @date 2019年12月9日13:29:34
 */
public class Solution_9 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
