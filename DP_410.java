public class DP_410 {
    public long count(int s[], int n, int amount) {
        // code here.
        long[] dp = new long[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = s[i]; j <= amount; j++) {
                dp[j] = dp[j - s[i]] + dp[j];
            }
        }

        return dp[amount];
    }
}