import java.util.Scanner;

public class DP424 {
    public static int LongestRepeatingSubsequence(String s) {
        // code here
        String s2 = s;
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (s.charAt(i - 1) == s2.charAt(j - 1) && i != j) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        return dp[n][n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        System.out.println(LongestRepeatingSubsequence(s));
        scan.close();
    }
}
