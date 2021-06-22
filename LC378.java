public class LC378 {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];

        while (l <= r) {
            int mid = (l + r) / 2;
            int count = kount(matrix, mid);
            if (count >= k)
                r = mid - 1;
            else
                l = mid + 1;
        }
        return l;
    }

    public static int kount(int[][] a, int num) {
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (a[i][j] <= num)
                    count++;
                else
                    break;
            }
            if (a[i][0] > num)
                break;
        }
        return count;
    }
}
