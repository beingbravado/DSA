import java.util.Arrays;
import java.util.Scanner;

public class DP422 {
    public static int maximizeCuts(int n, int x, int y, int z) {
        // Your code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[n] = 0;
        int k = x;
        for (int i = k; i <= n; i++) {
            if (dp[i - k] >= 0)
                dp[i] = Math.max(dp[i], 1 + dp[i - k]);
        }
        k = y;
        for (int i = k; i <= n; i++) {
            if (dp[i - k] >= 0)
                dp[i] = Math.max(dp[i], 1 + dp[i - k]);
        }
        k = z;
        for (int i = k; i <= n; i++) {
            if (dp[i - k] >= 0)
                dp[i] = Math.max(dp[i], 1 + dp[i - k]);
        }
        
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int x = scan.nextInt();
        int y = scan.nextInt();
        int z = scan.nextInt();
        System.out.println(maximizeCuts(n, x, y, z));
        scan.close();
    }
}
