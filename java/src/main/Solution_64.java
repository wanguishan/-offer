package main;

/**
 * 求1+2+……+n
 * 要求不能使用乘除法、for，while，if，else，switch，case等关键字及条件判断语句
 * @author Guishan Wan
 * @date 2020/4/1 7:45 下午
 */
public class Solution_64 {

    // 利用逻辑与的短路特性实现递归终止
    public static int sum_Solution(int n) {
        int sum = n;
        boolean flag = (n > 0) && ((sum += sum_Solution(n - 1)) > 0);
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sum_Solution(5));
    }
}
