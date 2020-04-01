package main;

/**
 * 构建乘积数组
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法
 * 注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];
 *
 * @author Guishan Wan
 * @date 2020/4/1 4:49 下午
 */
public class Solution_66 {

    /**
     * 不用额外空间，简易写法
     *
     * @param A
     * @return
     */
    public int[] multiply_2(int[] A) {
        if (A == null || A.length < 1) {
            return A;
        }
        int length = A.length;
        int[] B = new int[length];

        B[0] = 1;
        for (int i = 1; i < length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }

        int tmp = 1;
        for (int i = length-2; i >=0 ; i--) {
            tmp *= A[i + 1];
            B[i] *= tmp;
        }
        return B;

    }

    /**
     * 直观的动态规划解法
     *
     * @param A
     * @return
     */
    public int[] multiply_1(int[] A) {
        if ((A == null || A.length < 1)) {
            return A;
        }
        int length = A.length;
        int[] left = new int[length];
        int[] right = new int[length];

        left[0] = 1;
        for (int i = 1; i < length; i++) {
            left[i] = left[i - 1] * A[i - 1];
        }

        right[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * A[i + 1];
        }

        int[] B = new int[length];
        for (int i = 0; i < length; i++) {
            B[i] = left[i] * right[i];
        }
        return B;
    }
}
