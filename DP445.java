import java.util.Scanner;

public class DP445 {
    public static int minSubarraySum(int a[], int n) {
        // Your code here
        int[] dp = new int[n + 1];
        int max = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            if (a[i - 1] + dp[i - 1] < a[i-1])
                dp[i] = dp[i - 1];
            dp[i] += a[i - 1];
            max = Math.min(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(minSubarraySum(a, n));
        scan.close();
    }
}
