import java.util.Scanner;

public class DP432 {
    public static int eggDrop(int n, int k) {
        // Your code here
        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                if (i == 0 || j == 0 || i == 1) {
                    dp[i][j] = 0;
                    if (i == 1)
                        dp[i][j] = j;
                    continue;
                }
                dp[i][j] = Integer.MAX_VALUE;
                for (int t = 0; t < j; t++) {
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][t], dp[i][j - t - 1]));
                }
                dp[i][j]++;
            }
        }
        // for (int i = 0; i <= n; i++) {
        //     for (int j = 0; j <= k; j++) {
        //         System.out.print(dp[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        return dp[n][k];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int ans = eggDrop(n, k);
        System.out.println(ans);
        scan.close();
    }
}
