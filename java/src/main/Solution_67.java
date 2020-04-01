package main;

/**
 * 将一个字符串转换为整数，实现Integer.valueOf(String)功能，String不符合数字要求时返回0
 * // TODO 未判断溢出问题，待补充
 *
 * @author Guishan Wan
 * @date 2020/4/1 2:37 下午
 */
public class Solution_67 {
    public static int strToInt(String str) {

        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        // sign == 0，说明是正数，sign == 1，说明是负数
        // start用来区分第一位是否为符号位
        int sign = 0;
        int start = 0;
        int res = 0;


        if (str.charAt(0) == '-') {
            start = 1;
            sign = 1;
        } else if (str.charAt(0) == '+') {
            start = 1;
        }

        for (int i = start; i < str.length(); i++) {
            if (str.charAt(i) > '9' || str.charAt(i) < '0') {
                return 0;
            }
            res = res * 10 + str.charAt(i) - '0';
        }
        return sign == 0 ? res : res * -1;
    }

}
