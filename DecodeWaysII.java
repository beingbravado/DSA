public class DecodeWaysII {
    final int MOD = 1000000007;

    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // State & Initialize
        int len = s.length();
        long[] dp = new long[len + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '*' ? 9 : s.charAt(0) != '0' ? 1 : 0;

        // Function
        for (int i = 2; i <= len; i++) {
            if (s.charAt(i - 1) == '*') {
                dp[i] = 9 * dp[i - 1];
                if (s.charAt(i - 2) == '1') {
                    dp[i] = (dp[i] + 9 * dp[i - 2]) % MOD;
                } else if (s.charAt(i - 2) == '2') {
                    dp[i] = (dp[i] + 6 * dp[i - 2]) % MOD;
                } else if (s.charAt(i - 2) == '*') {
                    dp[i] = (dp[i] + 15 * dp[i - 2]) % MOD;
                }
            } else {
                dp[i] = s.charAt(i - 1) != '0' ? dp[i - 1] : 0;
                if (s.charAt(i - 2) == '1') {
                    dp[i] = (dp[i] + dp[i - 2]);
                    dp[i] = (dp[i] + MOD) % MOD;
                } else if (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '6') {
                    dp[i] = (dp[i] + dp[i - 2]);
                    dp[i] = (dp[i] + MOD) % MOD;
                } else if (s.charAt(i - 2) == '*') {
                    dp[i] = (dp[i] + (s.charAt(i - 1) <= '6' ? 2 : 1) * dp[i - 2]);
                    dp[i] = (dp[i] + MOD) % MOD;
                }
            }
        }

        return (int) dp[len] % MOD;
    }
}