import java.util.Scanner;

public class DP418 {
    static int mod = 1000000007;

    public static long countFriendsPairings(int n) {
        // code here
        long[] dp = new long[n + 2];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % mod;
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
