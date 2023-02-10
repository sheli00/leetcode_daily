/**
 * @Author sheli
 * leetcode2023/2/10每日一题
 **/
public class problem1223 {
    static final int MOD = 1000000007;

    public int dieSimulator(int n, int[] rollMax) {
        //dp[n][6]代表，第n次骰子点数为6的个数
        //最后答案输出sum dp[n][0-6]
        int[][] dp = new int[n+1][6];
        //初始化，第一次骰子点数为j的个数都为1
        for (int j = 0; j < 6; j++) {
            dp[1][j] = 1;
        }
        int[] sum = new int[n+1];
        sum[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 6; j++) {
                //计算窗口起始位置
                //第i次骰子，减去j这个数最多可以连续多少次，再往前移一位
                int pos = Math.max(i - rollMax[j] - 1, 0);
                //比如_、_、_、6、6、6这个序列，要先加上第5位为123456的个数，再减去第2位为12345的个数（因为这种情况，会导致第5次就6的次数用完）
                int sub = ((sum[pos] - dp[pos][j]) % MOD + MOD) % MOD;
                dp[i][j] = ((sum[i - 1] - sub) % MOD + MOD) % MOD;
                //特殊情况
                if (i <= rollMax[j]) {
                    dp[i][j] = (dp[i][j] + 1) % MOD;
                }
                sum[i] = (sum[i] + dp[i][j]) % MOD;
            }
        }
        return sum[n];
    }
}
