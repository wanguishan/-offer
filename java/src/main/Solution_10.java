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
/*    public static int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n + 1];
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        // System.out.println(Arrays.toString(fib));
        return fib[n];

    }*/

    public static int Fibonacci(int n) {
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

    public static void main(String[] args) {
        int n = 10;
        for (int i = 0; i < n; i++) {
            System.out.println(Fibonacci(i));
        }

    }

}
