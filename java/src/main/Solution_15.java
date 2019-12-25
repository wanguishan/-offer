package main;

/**
 * 二进制中1的个数
 *
 * 输入一个整数，输出该数二进制表示中1的个数
 *
 * 例如：把9表示成二进制是1001，有2位是1。因此，如果输入9，则函数输出2。
 *
 * @author Guishan Wan
 * @date 2019/12/25 11:04 下午
 */
public class Solution_15 {
    public int NumberOf1(int n) {
        int cnt = 0;
        while (n != 0) {
            cnt++;
            n = n & (n - 1);
        }
        return cnt;
    }

    // 方法二
    public int NumberOf1_2(int n) {
        int cnt = 0;
        for (int i = 0; i < 32; i++) {
            cnt += (n >> i) & 1;
        }
        return cnt;
    }
}
