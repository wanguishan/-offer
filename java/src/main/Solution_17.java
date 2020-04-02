package main;

import java.util.Arrays;

/**
 * 打印从1到最大的n位数
 *
 * @author Guishan Wan
 * @date 2020/4/2 4:03 下午
 */
public class Solution_17 {

    /**
     * 打印从1到最大的n位数
     * <p>
     * 此题需注意n位数构成的数字可能超过最大的int或者long能表示的范围。因此，采用数组来存储数字
     *
     * @param n n位数
     */
    public void print1ToMaxOfNDigits(int n) {
        if (n < 1) {
            return;
        }
        char[] chars = new char[n];
        Arrays.fill(chars, '0');
        while (increment(chars)) {
            printNumber(chars);
        }
    }

    /**
     * 打印字符数组表示的数字（需要省略前n个0）
     *
     * @param chars
     */
    private void printNumber(char[] chars) {
        int i = 0, n = chars.length;
        for (; i < n; i++) {
            if (chars[i] != '0') {
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (; i < n; i++) {
            sb.append(chars[i]);
        }
        System.out.println(sb.toString());
    }

    private boolean increment(char[] chars) {
        int n = chars.length;
        for (int i = n - 1; i >= 0; i--) {
            int sum = chars[i] - '0' + 1;
            if (sum > 9) {
                if (i == 0) {
                    return false;
                }
                chars[i] = '0';
            } else {
                chars[i]++;
                break;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution_17 solution_17 = new Solution_17();

        solution_17.print1ToMaxOfNDigits_2(2);
    }

    // 解法二：利用递归全排列，设置每一位，设置完之后，打印出来
    public void print1ToMaxOfNDigits_2(int n) {
        if (n < 1) {
            return;
        }
        char[] chars = new char[n];
        print1ToMaxOfNDigits_2(chars, n, 0);
    }

    private void print1ToMaxOfNDigits_2(char[] chars, int n, int i) {
        if (i == n) {
            printNumber(chars);
            return;
        }

        // 每一位分别设置从0到9
        for (int j = 0; j < 10; j++) {
            chars[i] = (char) (j + '0');
            print1ToMaxOfNDigits_2(chars, n, i + 1);
        }

    }


}
