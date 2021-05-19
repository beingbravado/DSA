import java.util.*;

public class DP411 {
    public static int knapSack(int w, int wt[], int val[], int n) {
        // your code here
        int dp[][] = new int[n + 1][w + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= w; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                int temp = 0;
                if (j >= wt[i - 1] && wt[i - 1] <= w)
                    temp = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                dp[i][j] = Math.max(temp, dp[i - 1][j]);
                // System.out.print(dp[i][j]+" ");
            }
            // System.out.println();
        }

        return dp[n][w];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int w = scan.nextInt();
        int[] val = new int[n];
        for (int i = 0; i < n; i++) {
            val[i] = scan.nextInt();
        }
        int[] wt = new int[n];
        for (int i = 0; i < n; i++) {
            wt[i] = scan.nextInt();
        }
        System.out.println(knapSack(w, wt, val, n));
        scan.close();
    }
}
