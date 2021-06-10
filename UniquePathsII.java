import java.util.Scanner;

public class UniquePathsII {
    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }
                if ((i == 1 && j == 1) && grid[i - 1][j - 1] == 0) {
                    dp[i][j] = 1;
                } else {
                    if (grid[i - 1][j - 1] == 1) {
                        continue;
                    }
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++)
                matrix[i][j] = scan.nextInt();
        }
        System.out.println(uniquePathsWithObstacles(matrix));
        scan.close();
    }
}
