package main;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 数据流中的中位数
 *
 * 设计一个支持以下两种操作的数据结构： 
 *      void addNum(int num) - 从数据流中添加一个整数到数据结构中。
 *      double findMedian() - 返回目前所有元素的中位数。
 *
 *  动态中位数解法：
 *      1. 把数组每次都排序 O(nlogn)
 *      2. 二分法寻找位置插入 O(n)
 *      3. 两个堆来维护 O(logn)
 *
 * @author Guishan Wan
 * @date 2020/4/16 12:39 下午
 */
public class Solution_41 {
    Queue<Integer> min;
    Queue<Integer> max;

    /** initialize your data structure here. */
    public Solution_41() {
        // 维护两个堆，上半区是最小堆，下半区是最大堆
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((o1, o2) -> (o2.compareTo(o1)));
    }

    /**
     * 放入过程：
     *      目标：max堆的个数 >= min堆的个数
     *      1. 先放max
     *      2. 再放min
     *      3. 可能放回max（max堆的个数 < min堆的个数时）
     *
     * @param num
     */
    public void addNum(int num) {
        max.offer(num);
        min.offer(max.poll());
        while (max.size() < min.size()) {
            max.offer(min.poll());
        }
    }

    /**
     *  取出过程：
     *      1. 当max堆的个数 > min堆的个数：取出max堆顶
     *      2. 当max堆的个数 = min堆的个数：求max堆顶与min堆顶的平均值
     *
     * @return
     */
    public double findMedian() {
        if (max.size() > min.size()) {
            return (double) max.peek();
        }
        return (max.peek() + min.peek()) / 2.0;
    }

}
