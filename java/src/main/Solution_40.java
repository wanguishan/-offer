package main;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 最小的k个数
 *
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author Guishan Wan
 * @date 2020/4/15 4:40 下午
 */
public class Solution_40 {


    /**
     * 解法一：二分 + 快排partition O(n)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_1(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return new int[0];
        }

        int start = 0, end = arr.length - 1;
        while (start < end) {
            int index = partition(arr, start, end);
            if (index == k - 1) {
                break;
            } else if (index > k - 1) {
                end = index - 1;
            } else {
                start = index + 1;
            }
        }
        return Arrays.copyOfRange(arr, 0, k);

    }

    private int partition(int[] arr, int start, int end) {
        int base = arr[start];
        int i = start, j = end;
        while (i != j) {
            while (i < j && arr[j] >= base) {
                j--;
            }
            while (i < j && arr[i] <= base) {
                i++;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        arr[start] = arr[i];
        arr[i] = base;
        return i;
    }

    /**
     * 解法二：维护一个大小为k的大顶堆（PriorityQueue实现）    O(nlogk)
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers_2(int[] arr, int k) {
        // 最大堆
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> (o2.compareTo(o1)));

        for (int i : arr) {
            queue.add(i);
            // 维护堆的最大个数为k
            while (!queue.isEmpty() && queue.size() > k) {
                queue.remove();
            }
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.remove();
        }
        return res;
    }

}
