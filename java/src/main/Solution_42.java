package main;

/**
 * 42. 连续子数组的最大和
 *
 * 输入一个整型数组，数组里有正数也有负数。
 * 数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 *
 * @author Guishan Wan
 * @date 2020/5/28 5:59 下午
 */
public class Solution_42 {
    public int maxSubArray(int[] nums) {
        int curSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            curSum = Math.max(nums[i], curSum + nums[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }

    /**
     * 动态规划
     *
     * @param nums
     * @return
     */
    public int maxSubArray_2(int[] nums) {

        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }

        }
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
