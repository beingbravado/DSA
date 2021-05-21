import java.util.Scanner;

public class DP416 {
    public static int editDistance(String x, String y) {
        // Code here
        char[] a = x.toCharArray();
        char[] b = y.toCharArray();
        int nx = x.length(), ny = y.length();
        int[][] dp = new int[nx + 1][ny + 1];

        for (int i = 0; i <= nx; i++) {
            for (int j = 0; j <= ny; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return Math.max(nx, ny) - dp[nx][ny];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = scan.next();
        System.out.println(editDistance(x, y));
        scan.close();
    }
}
