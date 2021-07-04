public class MaxSumOfRectNoLargerThanK {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            int[] a = new int[matrix.length];
            for (int t = j; t < matrix[0].length; t++) {
                for (int i = 0; i < matrix.length; i++) {
                    a[i] += matrix[i][t];
                }
                ans = Math.max(ans, kadane(a, k));
                if (ans == k)
                    return k;
            }
        }
        return ans;
    }

    public static int kadane(int[] a, int k) {
        int[] dp = new int[a.length + 1];
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = dp[i - 1] + a[i - 1];
        }
        int num = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            for (int j = i + 1; j < dp.length; j++) {
                if (dp[j] - dp[i] == k)
                    return k;
                if (dp[j] - dp[i] < k)
                    num = Math.max(num, dp[j] - dp[i]);
            }
        }
        return num;
    }
}
