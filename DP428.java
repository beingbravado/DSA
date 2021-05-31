import java.util.Scanner;

public class DP428 {
    public static int maxSumIS(int a[], int n) {
        // code here.
        int[] dp = new int[n];
        int max = 0;
        for (int i = 0; i < n; i++) {
            int next = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (a[i] > a[j])
                    next = Math.max(next, dp[j]);
            }
            dp[i] = a[i]+next;
            // for (int j = 0; j < n; j++)
            // System.out.print(dp[j] + " ");
            // System.out.println();
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(maxSumIS(a, n));
        scan.close();
    }
}
