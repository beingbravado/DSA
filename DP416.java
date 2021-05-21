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
                // System.out.print(dp[i][j] + " ");
            }
            // System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        while (nx > 0 && ny > 0) {
            if (a[nx - 1] == b[ny - 1]) {
                sb.append(a[nx - 1]);
                nx--;
                ny--;
            } else if (dp[nx][ny - 1] > dp[nx - 1][ny]) {
                ny--;
            } else {
                nx--;
            }
        }
        char[] s = sb.reverse().toString().toCharArray();
        nx = x.length();
        ny = y.length();
        int ans = 0;

        int i = 0, j = 0, k = 0;
        int xCount = 0, yCount = 0;
        while (i < nx && j < ny && k < s.length) {
            while (a[i] != s[k]) {
                xCount++;
                i++;
            }
            while (b[j] != s[k]) {
                yCount++;
                j++;
            }
            ans += Math.max(xCount, yCount);
            k++;
            i++;
            j++;
            xCount = 0;
            yCount = 0;
        }
        ans += Math.max(nx - i, ny - j);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        String x = scan.next();
        String y = scan.next();
        System.out.println(editDistance(x, y));
        scan.close();
    }
}
