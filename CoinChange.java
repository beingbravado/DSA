import java.util.Arrays;
import java.util.Scanner;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        // initializing and filling dp array;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
            }
        }
        
        int ans = (int) dp[amount];
        if (dp[amount] >= Integer.MAX_VALUE)
            ans = -1;
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int amount = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scan.nextInt();
        }
        int ans = coinChange(a, amount);
        System.out.println(ans);
        scan.close();
    }
}
