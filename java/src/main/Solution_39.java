package main;

/**
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author Guishan Wan
 * @date 2020/4/15 1:53 下午
 */
public class Solution_39 {
    /**
     * 遍历数组时保存两个值，一个是数组中的数字，另一个是次数
     * 当我们遍历到下一个数字的时候，如果该数和之前保存的数相同，则次数+1，如果不同则次数-1
     * 如果次数为0，则保存下一个数字，并将次数设置为1
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int times = 0, result = 0;

        for (int num : nums) {
            if (times == 0) {
                result = num;
                times = 1;
            } else if (result == num) {
                times++;
            } else {
                times--;
            }
        }
        return result;
    }
}
