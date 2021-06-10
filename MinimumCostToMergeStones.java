import java.util.Scanner;

public class MinimumCostToMergeStones {
    public static int mergeStones(int[] a, int k) {
        int n = a.length;
        if ((n - 1) % (k - 1) != 0)
            return -1;
        int[][] dp = new int[n][n];
        for (int g = k - 1; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                dp[i][j] = Math.min(j <= 0 ? 0 : dp[i][j - 1], i >= n - 1 ? 0 : dp[i + 1][j]);
                if (g % (k - 1) == 0) {
                    for (int x = i; x <= j; x++)
                        dp[i][j] += a[x];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[0][n - 1];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int k = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(mergeStones(a, k));
        scan.close();
    }
}
