import java.util.Scanner;

public class DP423 {
    public static int lcs(int x, int y, String s1, String s2) {
        // your code here
        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();
        int[][] dp = new int[x + 1][y + 1];

        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= y; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                    continue;
                }

                if (a[i - 1] == b[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[x][y];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String s1 = scan.next();
        String s2 = scan.next();
        System.out.println(lcs(s1.length(), s2.length(), s1, s2));
        scan.close();
    }
}
