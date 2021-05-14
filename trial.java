import java.util.*;

public class trial {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        int n = a.length();
        int m = b.length();
        Integer[][] dp = new Integer[n + 1][m + 1];
        for (int i = 0; i <= n; i++)
            dp[i][0] = 0;
        for (int i = 0; i <= m; i++)
            dp[0][i] = 0;

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        // int max = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    // max = Math.max(max, dp[i][j]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }
        StringBuilder ans = new StringBuilder();
        int i = n, j = m;
        while (i > 0 && j > 0) {
            if (dp[i - 1][j] == dp[i][j - 1] && dp[i][j] > dp[i - 1][j]) {
                ans.append(a.charAt(i - 1));
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else if (dp[i - 1][j] < dp[i][j - 1]) {
                    j--;
                } else {
                    i--;
                    j--;
                }
            }
        }
        System.out.println(dp[n][m]);
        System.out.println(ans.reverse().toString());
        scan.close();
    }
}
