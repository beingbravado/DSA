import java.util.Arrays;
import java.util.Scanner;

public class DP430 {
    public static int longestSubsequence(int n, int a[]) {
        // code here
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 1);
        int ans = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (Math.abs(a[i] - a[j]) == 1) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                }
            }
            ans = Math.max(ans, dp[i]);
            // System.out.print(dp[i] + " ");
        }
        // System.out.println();
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        int ans = longestSubsequence(n, a);
        System.out.println(ans);
        scan.close();
    }
}
