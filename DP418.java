import java.util.Scanner;

public class DP418 {
    static int mod = 1000000007;

    public static long countFriendsPairings(int n) {
        // code here
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (i % 2 == 0)
                dp[i] = (2 * dp[i - 1] + dp[i - 2]) % mod;
            else
                dp[i] = (1 + 3 * (dp[i - 1] - 1)) % mod;
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(countFriendsPairings(n));
        scan.close();
    }
}
