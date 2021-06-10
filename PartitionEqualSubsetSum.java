import java.util.Scanner;

public class PartitionEqualSubsetSum {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        } else {
            sum /= 2;
            boolean[][] dp = new boolean[nums.length + 1][sum + 1];
            for (int j = 0; j <= nums.length; j++) {
                for (int i = 0; i <= sum; i++) {
                    if (i == 0 || j == 0) {
                        dp[j][0] = true;
                        continue;
                    }
                    if (i >= nums[j - 1])
                        dp[j][i] = dp[j - 1][i] | dp[j - 1][i - nums[j - 1]];
                    else
                        dp[j][i] = dp[j - 1][i];
                }
                // for (int x = 0; x <= sum; x++) {
                //     System.out.print(dp[j][x] + " ");
                // }
                // System.out.println();
            }
            return dp[nums.length][sum];
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] matrix = new int[n];
        for (int j = 0; j < n; j++)
            matrix[j] = scan.nextInt();
        System.out.println(canPartition(matrix));
        scan.close();
    }
}
