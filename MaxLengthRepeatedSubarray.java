public class MaxLengthRepeatedSubarray {
    public int findLength(int[] a, int[] b) {
        int n = a.length, m = b.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (b[j - 1] == a[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (ans < dp[i][j])
                        ans = dp[i][j];
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }
}
