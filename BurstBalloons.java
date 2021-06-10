import java.util.Scanner;

public class BurstBalloons {
    public static int maxCoins(int[] a) {
        int n = a.length;
        int[][] dp = new int[n][n];
        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                for (int k = i; k <= j; k++) {
                    int left = k == 0 ? 0 : dp[i][k - 1];
                    int right = k == n - 1 ? 0 : dp[k + 1][j];
                    int total = (i == 0 ? 1 : a[i - 1]) * a[k] * (j == n - 1 ? 1 : a[j + 1]);

                    dp[i][j] = Math.max(dp[i][j], left + right + total);
                }
            }
        }

        // for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++)
        //         System.out.print(dp[i][j] + " ");
        //     System.out.println();
        // }
        return dp[0][n - 1];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(maxCoins(a));
        scan.close();
    }
}
