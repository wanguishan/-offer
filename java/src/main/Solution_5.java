package main;

// 替换空格
//
// 实现一个函数，把字符串中的每个空格替换成"%20"。
// input: 'We are happy.'
//
// output: 'We%20are%20happy.'

/**
 * @author wanguishan
 * @date 2019年12月4日10:54:29
 */
public class Solution_5 {
     public static String replaceSpace(StringBuffer str) {
        // 字符串尾部填充任意字符
        // 从前往后遍历，每遇到一个空格，便在尾部填充两个空格
        int p1 = str.length() - 1;
        for (int i = 0; i <= p1; i++) {
            if (str.charAt(i) == ' ') {
                str.append("  ");
            }
        }

        // p1指向原字符串尾部，p2指向填充后的字符串尾部，p1和p2都从后往前遍历
        // 当p1遍历到一个空格时，就需要令p2指向的位置依次填充02%（注意是逆序的），否则就填充上p1指向字符的值
        int p2 = str.length() - 1;
        while (p1 >= 0 && p2 > p1) {
//            char charAtP1 = str.charAt(p1);
            char charAtP1 = str.charAt(p1--);
            if (charAtP1 == ' ') {
                str.setCharAt(p2--, '0');
                str.setCharAt(p2--, '2');
                str.setCharAt(p2--, '%');
            } else {
                str.setCharAt(p2--, charAtP1);
            }
//            p1--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        String str = "I am Wan Guishan!";
        String result = replaceSpace(new StringBuffer(str));

        System.out.printf("before: %s\n", str);
        System.out.printf("after: %s", result);
    }
}
