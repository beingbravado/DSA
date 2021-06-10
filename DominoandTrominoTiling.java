import java.util.Scanner;

public class DominoandTrominoTiling {
    public static int numTilings(int n) {
        int MOD = 1000000007;
        long[] dp = new long[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 5;
        for (int i = 4; i <= n; i++)
            dp[i] = (2 * dp[i - 1] + dp[i - 3]) % MOD;
        return (int) (dp[n] % MOD);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(numTilings(n));
        scan.close();
    }
}
