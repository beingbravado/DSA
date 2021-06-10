import java.util.Scanner;

public class MaximalSquare {
    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        // System.out.println(m + " " + n);
        int[][] dp = new int[m + 1][n + 1];
        int ans = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if (matrix[i - 1][j - 1] == '0') {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans * ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        char[][] matrix = new char[m][n];
        for (int i = 0; i < m; i++) {
            char[] s = scan.next().trim().toCharArray();
            for (int j = 0; j < n; j++)
                matrix[i][j] = s[j];
        }
        System.out.println(maximalSquare(matrix));
        scan.close();
    }
}
