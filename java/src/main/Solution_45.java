package main;

import java.util.Arrays;

/**
 * 把数组排成最小的数
 *
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个
 *
 * 区分 Comparable和 Comparator:
 *  1. Comparable是一个接口，其中可以重写compareTo()方法
 *  2. Comparator是一个比较器类：
 *      —— 可以重写其中的compare(Object o1, Object o2)方法
 *      —— Comparator对象，可以被传入Arrays.sort(), PriorityQueue()中
 *
 * @author Guishan Wan
 * @date 2020/4/15 3:35 下午
 */
public class Solution_45 {
    public String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        // Step01: int 类型的数组转化为String类型的数组： for循环
        String[] ss = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ss[i] = String.valueOf(nums[i]);
        }

        // Step02: 关键：对String数组进行排序
/*        Arrays.sort(ss, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 两个字符串拼接，把拼接的结果较小的放在前面
                return (s1 + s2).compareTo(s2 + s1);
            }
        });*/

        // 可用lambda表达式实现
        Arrays.sort(ss, (s1, s2) -> (s1 + s2).compareTo(s2 + s1));

        // Step03: String[] 数组转化为String类型
        StringBuilder sb = new StringBuilder();
        for (String s : ss) {
            sb.append(s);
        }

        return sb.toString();
    }

}
