package main;

/**
 * 剪绳子
 * <p>
 * 给你一根长度为n的绳子，请把绳子剪成m段(m,n都是整数，且n>1,m>1)
 * 每段绳子的长度记为k[0],k[1],k[2],...,k[m]。请问k[0]*k[1]*...*k[m]可能的最大乘积是多少
 * <p>
 * 例如，当绳子的长度为8时，我们把它剪成长度分别为2，3，3的三段，此时得到的最大乘积为18
 *
 * @author wanguishan
 * @date 2019年12月18日10:56:06
 */
public class Solution_14 {

    public static void main(String[] args) {
        Solution_14 solution_14 = new Solution_14();
        for (int i = 0; i < 40; i += 5) {
            System.out.print("target=" + i + ", result=" + solution_14.cutRope_1(i) + "\n");
        }
    }

    // 贪心算法
    public int cutRope_1(int target) {
        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }
        int timesOf3 = target / 3;
        if (target - timesOf3 * 3 == 1) {
            timesOf3--;
        }
        int timesOf2 = (target - timesOf3 * 3) / 2;
        return (int) (Math.pow(3, timesOf3) * Math.pow(2, timesOf2));
    }

    // 动态规划法
    public int cutRope_2(int target) {

        if (target < 2) {
            return 0;
        }
        if (target == 2) {
            return 1;
        }
        if (target == 3) {
            return 2;
        }

        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max;
        for (int i = 4; i <= target; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }
        return products[target];

    }
}
