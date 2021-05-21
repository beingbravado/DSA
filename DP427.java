import java.util.Scanner;

public class DP427 {

    public static int LCSof3(String a, String b, String c, int n1, int n2, int n3) {
        // code here

        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        char[] z = c.toCharArray();
        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];

        for (int i = 0; i <= n1; i++) {
            for (int j = 0; j <= n2; j++) {
                for (int k = 0; k <= n3; k++) {
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                        continue;
                    }

                    if (x[i - 1] == y[j - 1] && x[i - 1] == z[k - 1]) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                    }
                }
            }
        }

        return dp[n1][n2][n3];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        String c = scan.next();
        System.out.println(LCSof3(a, b, c, a.length(), b.length(), c.length()));
        scan.close();
    }
}
