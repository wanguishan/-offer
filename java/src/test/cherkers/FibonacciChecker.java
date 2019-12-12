package test.cherkers;

/**
 * @author wanguishan
 * @date 2019年12月12日10:47:55
 */
public class FibonacciChecker {
    private int[] fib = new int[40];

    /**
     * 输出斐波那契数列第n项的值
     *
     * @param n input number
     * @return fib[n]
     */
    public int Fabonacci(int n) {
        fib[1] = 1;
        for (int i = 2; i < fib.length; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        return fib[n];
    }
}
