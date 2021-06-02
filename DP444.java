import java.util.Scanner;

public class DP444 {
    public static int maxSubarraySum(int a[], int n) {
        // Your code here
        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (a[i - 1] + dp[i - 1] > a[i - 1])
                dp[i] = dp[i - 1];
            dp[i] += a[i - 1];
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static int maxSubarraySumbyDP(int a[], int n) {
        // Your code here
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0)
                    dp[i][j] = a[i];
                else
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(maxSubarraySum(a, n));
        scan.close();
    }
}
