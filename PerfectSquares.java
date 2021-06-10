import java.util.Arrays;
import java.util.Scanner;

public class PerfectSquares {
    public static int numSquares(int n) {
        int m = (int) (Math.sqrt(n));
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 1; j <= m; j++) {
            for (int i = j * j; i <= n; i++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
            }
        }
        return (int) dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(numSquares(n));
        scan.close();
    }
}
