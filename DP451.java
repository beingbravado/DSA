import java.util.Scanner;

public class DP451 {
    public static int mod = 1000000007;

    public static long countPS(String s) {
        // Your code here
        int n = s.length();
        long[][] dp = new long[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0)
                    dp[i][j] = 1;
                else
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + (s.charAt(i) == s.charAt(j) ? 1 : -dp[i + 1][j - 1]);
                dp[i][j] = (dp[i][j] + mod) % mod;
            }
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String str = scan.next();
        System.out.println(countPS(str));
        scan.close();
    }
}
