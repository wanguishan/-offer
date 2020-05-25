package main;

import java.util.Stack;

/**
 * 包含min函数的栈
 *
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)
 *
 * @author Guishan Wan
 * @date 2020/4/16 6:12 下午
 */
public class Solution_30 {
    Stack<Integer> stack;
    int min;

    /**
     * lastMin双入栈实现
     */
    public Solution_30() {
        stack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    /** 发现更小的值，则lastMin双入栈 */
    public void push(int x) {
        if (x <= min) {         // 注意：边界条件是 <=, 因为需要出栈两次，所以这里入栈两次
            stack.push(min);
            min = x;
        }
        stack.push(x);
    }

    /** 发现出栈的是min，则把下一个出栈的设为新的min */
    public void pop() {
        if (stack.pop() == min) {
            min = stack.pop();
        }

    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}

/**
 * 辅助栈实现
 */
class MinStack {
    Stack<Integer> s1;
    Stack<Integer> s2;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public void push(int x) {
        // 注：辅助栈为空时，也要把当前值压栈
        if (s2.isEmpty() || x <= s2.peek()) {
            s2.push(x);
        }
        s1.push(x);
    }

    public void pop() {

        // 对于Integer，如果用 == 比较，需保证[-128,127]
        if (s1.pop().equals(s2.peek())) {
            s2.pop();
        }
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
}
