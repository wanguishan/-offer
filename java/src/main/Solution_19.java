package main;

import java.util.regex.Pattern;

/**
 * 正则表达式匹配
 *
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 解法：
 * 判断模式中第二个字符是否是*
 *      1. 若不匹配，在模式串上向右移动两个字符j+2，相当于a*被忽略
 *      2. 若匹配，字符串后移i+1。此时模式串可以移动两个字符j+2，也可以不移动j
 * 若不是，看当前字符与模式串的当前字符是否匹配，即str[i] == pattern[j] || pattern[j] == '.'：
 *      1. 若匹配，则字符串与模式串都向右移动一位，i+1， j+1
 *      2. 若不匹配，则返回false
 *
 * @author Guishan Wan
 * @date 2020/4/3 1:32 下午
 */
public class Solution_19 {
    /**
     *
     * @param s 字符串
     * @param p 模式串
     * @return 是否匹配
     */
    public boolean isMatch(String s, String p) {
        if (s == null || p == null) {
            return false;
        }
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();
        return match(str, 0, str.length, pattern, 0, pattern.length);

    }

    private boolean match(char[] str, int i, int len1, char[] pattern, int j, int len2) {
        if (i == len1 && j == len2) {
            return true;
        }

        // pattern已经走到最后，而str还有未匹配的
        // str走到最后，而pattern还没走完，此时是允许的
        if (j == len2) {
            return false;
        }

        if (j + 1 < len2 && pattern[j + 1] == '*') {
            if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
                return match(str, i, len1, pattern, j + 2, len2)
                        || match(str, i + 1, len1, pattern, j, len2)
                        || match(str, i + 1, len1, pattern, j + 2, len2);
            }
            return match(str, i, len1, pattern, j + 2, len2);
        }

        if (i < len1 && (str[i] == pattern[j] || pattern[j] == '.')) {
            return match(str, i + 1, len1, pattern, j + 1, len2);
        }
        return false;
    }
}
