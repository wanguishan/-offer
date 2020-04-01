package main;

/**
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号
 *
 * @author Guishan Wan
 * @date 2020/4/1 7:07 下午
 */
public class Solution_65 {
    /**
     * 先对两数进行异或，求得相加不进位的结果；再循环对两数进行按位与运算，并左移一位，直至进位为0
     *
     * @param num1 数1
     * @param num2 数2
     * @return 两数之和
     */
    public static int add(int num1, int num2) {

        int sum, carry;
        do {
            sum = num1 ^ num2;              // 不带进位的加法
            carry = (num1 & num2) << 1;     // 进位
            num1 = sum;
            num2 = carry;
        } while (num2 != 0);                // 进位不为0则继续执行加法处理进位
        return num1;
    }
}
