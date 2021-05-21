import java.util.Scanner;

public class DP419 {
    public static int maxGold(int n, int m, int mine[][]) {
        // code here
        int ans = 0;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++)
            dp[i][m - 1] = mine[i][m - 1];
        for (int j = m - 2; j >= 0; j--) {
            for (int i = 0; i < n; i++) {
                int l = 0, r = 0;
                if (i > 0)
                    l = dp[i - 1][j + 1];
                if (i < n - 1)
                    r = dp[i + 1][j + 1];

                dp[i][j] = mine[i][j] + Math.max(dp[i][j + 1], Math.max(l, r));
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        for (int i = 0; i < n; i++)
            ans = Math.max(ans, dp[i][0]);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mine = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                mine[i][j] = scan.nextInt();
        System.out.println(maxGold(n, m, mine));
        scan.close();
    }
}
