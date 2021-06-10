import java.util.Scanner;

public class UniqueBinarySearchTree {
    public static int numTrees(int n) {
        int[] dp = new int[20];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 4; i <= n; i++)
            for (int j = 0; j < n; j++)
                dp[i] += dp[j] * dp[n - j - 1];
        return dp[n];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        System.out.println(numTrees(n));
        scan.close();
    }
}
