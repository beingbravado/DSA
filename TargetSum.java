import java.util.Arrays;
import java.util.Scanner;

public class TargetSum {
    public static int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if ((sum - target) % 2 == 1 || target > sum)
            return 0;
        sum = (sum - target) / 2;
        int[][] dp = new int[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j >= nums[i - 1])
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]];
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();
        int[] matrix = new int[n];
        for (int j = 0; j < n; j++)
            matrix[j] = scan.nextInt();
        System.out.println(findTargetSumWays(matrix, target));
        scan.close();
    }
}
