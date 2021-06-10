import java.util.Arrays;
import java.util.Scanner;

public class TwoKeysKeyboard {
    public static int minSteps(int n) {
        long[] dp = new long[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = i - 1; j >= 1; j--) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + (i / j));
                    break;
                }
            }
        }
        if (n == 1)
            dp[1] = 0;
        return (int) dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(minSteps(n));
        scan.close();
    }
}
