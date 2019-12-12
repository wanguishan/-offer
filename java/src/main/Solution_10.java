package main;

/**
 * 斐波那契数列
 *
 * 求斐波那契数列的第n项
 *
 * n=0时，f(n)=0
 * n=1时，f(n)=1
 * n>1时，f(n)=f(n-1)+f(n-2)
 *
 * @author wanguishan
 * @date 2019年12月9日13:54:54
 */
public class Solution_10 {
    // 动态规划法
    public static int Fibonacci_1(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];

    }

    // 上面方法的改进，只存储i-1和i-2的值就能求解第i项
    // 将空间复杂度由 O(n) 降低为 O(1)
    public static int Fibonacci_2(int n) {
        if (n <= 1) {
            return n;
        }
        int f0 = 0, f1 = 1;
        int res = 0;
        for (int i = 2; i <= n; i++) {
            res = f0 + f1;
            f0 = f1;
            f1 = res;
        }
        return res;
    }

}
