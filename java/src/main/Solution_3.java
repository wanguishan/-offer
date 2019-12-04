package main;

// 找出数组中重复的数字
// 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
// 数组中某些数字是重复的，但不知道有几个数字是重复的，也不知道每个数字重复几次。
// 请找出数组中任意一个重复的数字。
//
// input: 输入长度为7的数组[2, 3, 1, 0, 2, 5, 3]
//
// output: [2, 3]

public class Solution_3 {
    public static boolean duplicate(int[] numbers, int length, int[] duplication) {
        if (numbers == null || length <= 0) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            while (numbers[i] != i) {
                if (numbers[i] == numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }
        }
        return false;
    }

    private static void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    public static void main(String[] args) {
        int[] numbers = {2, 3, 1, 0, 2, 5, 3};
        int length = numbers.length;
        int[] duplication = new int[length];

        System.out.println(duplicate(numbers, length, duplication));
    }
}
