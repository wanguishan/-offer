package main;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 滑动窗口的最大值
 *
 * @author Guishan Wan
 * @date 2020/4/16 1:59 下午
 */
public class Solution_59 {
    /**
     * 通过单调双端队列Deque： O(n)  First <====> Last
     *
     * @param nums 指定数组
     * @param k 滑动窗口大小
     * @return 所有滑动窗口最大值组成的数组
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n == 0 || k == 0) {
            return nums;
        }
        int[] res = new int[n - k + 1] ;

        // deque里面存的是数组的index，不是值
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Step1: 头 移除头部，保证窗口的长度范围
            if (!deque.isEmpty() && deque.getFirst() < (i - k + 1)) {
                deque.removeFirst();
            }

            // Step2: 尾 移除尾部小于当前值的元素，原理参考篮球队长模型，去除不可能的元素
            while (!deque.isEmpty() && nums[deque.getLast()] <= nums[i]) {
                deque.removeLast();
            }

            // Step3: 尾 尾部加入，即滑动窗口向右扩充
            deque.addLast(i);

            // Step4: 头 从头部返回当前窗口最大值
            if (i >= k - 1) {
                res[i - k + 1] = nums[deque.getFirst()];
            }
        }
        return res;
    }
}

/**
 * 队列的最大值
 *
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 */
class MaxQueue {
    Queue<Integer> queue;   // 主队列
    Deque<Integer> deque;   // 辅助队列

    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.getFirst();
    }

    public void push_back(int value) {
        // 主队列正常入队
        queue.add(value);
        // 辅助队列，从尾部清除比当前值更小的元素
        while (!deque.isEmpty() && deque.getLast() < value) {
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        // res是主队列出队的值
        int res = queue.poll();
        if (res == deque.getFirst()) {
            deque.removeFirst();
        }
        return res;
    }
}