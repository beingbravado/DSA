public class LongestIncreasingSequence {
    public int lengthOfLIS(int[] a) {
        int[] dp = new int[a.length];
        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j]) {
                    if (dp[i] <= dp[j])
                        dp[i] = dp[j] + 1;
                }
            }
            if (ans < dp[i])
                ans = dp[i];
        }
        return ans + 1;
    }
}
