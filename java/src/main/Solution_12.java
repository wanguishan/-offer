package main;

/**
 * 矩阵中的路径
 *
 * 设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子
 * 如果一条路径经过了矩阵中的某一个格子，则之后不能再次进入这个格子
 *
 * 例如 [[a, b, t, g], [c, f, c, s], [j, d, e, h]] 这样的3 X 4 矩阵中包含一条字符串"bfce"的路径，
 * 但是矩阵中不包含"abfb"路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 *
 * @author wanguishan
 * @date 2019年12月10日15:25:21
 */
public class Solution_12 {

    private final static int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int rows, cols;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (rows == 0 || cols == 0) {
            return false;
        }
        this.rows = rows;
        this.cols = cols;
        boolean[][] marked = new boolean[rows][cols];
        char[][] new_matrix = buildMatrix(matrix);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backTracking(new_matrix, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] matrix, char[] str, boolean[][] marked, int pathLen, int r, int c) {
        if (pathLen == str.length) {
            return true;
        }
        if (r < 0 || r >= rows || c < 0 || c >= cols || matrix[r][c] != str[pathLen] || marked[r][c]) {
            return false;
        }
        marked[r][c] = true;

        for (int[] n : next) {
            if (backTracking(matrix, str, marked, pathLen + 1, r + n[0], c + n[1])) {
                return true;
            }
        }
        marked[r][c] = false;
        return false;
    }

    private char[][] buildMatrix(char[] array) {
        char[][] matrix = new char[rows][cols];
        int index = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                matrix[r][c] = array[index++];
            }
        }
        return matrix;
    }

}
