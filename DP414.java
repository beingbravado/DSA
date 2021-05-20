import java.util.*;

public class DP414 {
    public static long findCatalan(int n) {
        // Your code here
        long[] dp = new long[n + 1];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
            // System.out.print(dp[i]+" ");
        }
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(findCatalan(n));
        scan.close();
    }
}
