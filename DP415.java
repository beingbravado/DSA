import java.util.Scanner;

public class DP415 {
    public static int matrixMultiplication(int n, int a[]) {
        // code here
        int m = n - 1;
        int[][] dp = new int[m][m];
        for (int g = 1; g < m; g++) {
            for (int i = 0, j = g; j < m; i++, j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++)
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j] + a[i] * a[k + 1] * a[j + 1]);
            }
        }
        // for (int i = 0; i < m; i++) {
        //     for (int j = 0; j < m; j++)
        //         System.out.print(dp[i][j] + " ");
        //     System.out.println();
        // }
        return dp[0][m - 1];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        System.out.println(matrixMultiplication(n, a));
        scan.close();
    }
}
