public class LC5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int x = 0, y = 0;
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; i < n && j < n; i++, j++) {
                if (g < 2) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                    if (dp[i][j]) {
                        x = i;
                        y = j;
                    }
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j));
                    if (dp[i][j]) {
                        x = i;
                        y = j;
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = x; i <= y; i++)
            sb.append(s.charAt(i));
        return sb.toString();
    }
}
