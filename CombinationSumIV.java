import java.util.Scanner;

public class CombinationSumIV {
    public static int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int j = 1; j <= target; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
                System.out.print(dp[j] + " ");
            }
            System.out.println();
        }
        return dp[target];
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int target = scan.nextInt();
        int[] matrix = new int[n];
        for (int j = 0; j < n; j++)
            matrix[j] = scan.nextInt();
        System.out.println(combinationSum4(matrix, target));
        scan.close();
    }
}
