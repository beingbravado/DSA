import java.util.Arrays;
import java.util.Scanner;

public class NumberofLongestIncreasingSubsequence {
    public static int findNumberOfLIS(int[] a) {
        int n = a.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 0;
        for (int i = 1; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) {
                    dp[i] = Math.max(dp[i], 1 + dp[j]);
                } else if (a[j] == a[i]) {
                    dp[i] = dp[j];
                }
            }
        }
        for (int k = 0; k < n; k++)
            System.out.print(dp[k] + " ");
        System.out.println();
        for (int k = 0; k < n; k++)
            max = Math.max(max, dp[k]);
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(findNumberOfLIS(a));
        scan.close();
    }
}
