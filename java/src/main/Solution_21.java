package main;

import java.util.Arrays;

/**
 * 调整数组顺序使奇数位与偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变
 *
 * @author Guishan Wan
 * @date 2020/4/3 2:50 下午
 */
public class Solution_21 {
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        int numsOfOdd = 0;
        int[] bak = new int[array.length];
//        int[] bak = Arrays.copyOf(array, array.length);
        for (int i = 0; i< array.length; i++) {
            bak[i] = array[i];
            if (bak[i] % 2 == 1) {
                numsOfOdd++;
            }
        }

        int i = 0, j = numsOfOdd;
        for (int val : bak) {
            if (val % 2 == 1) {
                array[i++] = val;
            } else{
                array[j++] = val;
            }
        }
    }

}
