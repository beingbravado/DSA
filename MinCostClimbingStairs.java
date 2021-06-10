import java.util.Scanner;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            // System.out.print(dp[i] + " ");
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] cost = new int[n];
        for (int i = 0; i < n; i++)
            cost[i] = scan.nextInt();
        System.out.println(minCostClimbingStairs(cost));
        scan.close();
    }
}
