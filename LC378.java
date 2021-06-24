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
            int l = 0, r = a.length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (a[i][mid] > num)
                    r = mid - 1;
                else
                    l = mid + 1;
            }
            count += l;
            if (a[i][0] > num)
                break;
        }
        return count;
    }
}
