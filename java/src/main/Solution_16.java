package main;

/**
 * 数值的整数次方
 *
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方
 * 保证base和exponent不同时为0
 *
 * @author Guishan Wan
 * @date 2020/2/29 9:59 下午
 */
public class Solution_16 {
    public double power(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = 1;
        for (int i = 0; i < Math.abs(exponent); i++) {
            res *= base;
        }
        return exponent > 0 ? res : 1 / res;
    }

    // 递归法
    public double power_2(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double res = power_2(base, Math.abs(exponent) >> 1);
        res *= res;
        if ((exponent & 1) == 1) {
            res *= base;
        }
        return exponent > 0 ? res : 1 / res;
    }
}

