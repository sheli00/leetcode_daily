/**
 * @Author sheli
 * leetcode2023/2/17每日一题
 **/
public class problem1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 该点左边一的数量
        // 该点上面一的数量
        int[][] left = new int[m + 1][n + 1];
        int[][] up = new int[m + 1][n + 1];
        int maxBorder = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //只统计该点为一的
                if (grid[i - 1][j - 1] == 1) {
                    left[i][j] = left[i][j - 1] + 1;
                    up[i][j] = up[i - 1][j] + 1;
                    //选出左和上的短边
                    int border = Math.min(left[i][j], up[i][j]);
                    //选出左点的上和上点的左的短边
                    while (left[i - border + 1][j] < border || up[i][j - border + 1] < border) {
                        border--;
                    }
                    maxBorder = Math.max(maxBorder, border);
                }
            }
        }
        return maxBorder*maxBorder;
    }
}
