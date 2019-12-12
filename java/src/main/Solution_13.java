package main;

/**
 * 机器人的运动范围
 *
 * 地上有一个m行和n列的方格。
 * 一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7=18。但是，它不能进入方格（35,38），因为3+5+3+8=19。
 * 请问该机器人能够达到多少个格子？
 *
 * @author wanguishan
 * @date 2019年12月12日09:37:27
 */
public class Solution_13 {
    private static final int[][] next = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int rows, cols;
    private int threshold;
    private int[][] digitSum;
    private int cnt = 0;

    public int movingCount(int threshold, int rows, int cols) {
        this.threshold = threshold;
        this.rows = rows;
        this.cols = cols;
        this.digitSum = sumOfDigits();

        boolean[][] visited = new boolean[rows][cols];

        DFS(visited, 0, 0);
        return cnt;
    }

    private void DFS(boolean[][] visited, int r, int c) {
        if (r < 0 || r >= rows || c < 0 || c >= cols || visited[r][c]) {
            return;
        }
        visited[r][c] = true;
        if (digitSum[r][c] > threshold) {
            return;
        }
        cnt++;
        for (int[] n : next) {
            DFS(visited, r + n[0], c + n[1]);
        }
    }

    private int[][] sumOfDigits() {
        int[] sumOfDigitsArray = new int[Math.max(rows, cols)];
        for (int i = 0; i < sumOfDigitsArray.length; i++) {
            int n = i;
            while (n > 0) {
                sumOfDigitsArray[i] += n % 10;
                n /= 10;
            }
        }
        int[][] digitSum = new int[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                digitSum[r][c] = sumOfDigitsArray[r] + sumOfDigitsArray[c];
            }
        }
        return digitSum;
    }

}
