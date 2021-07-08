public class KthSmallestElementInSortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int l = matrix[0][0], r = matrix[n - 1][n - 1];
        while (l <= r) {
            int mid = (l + r) / 2;
            if (small(matrix, mid, n) < k)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    public static int small(int[][] matrix, int num, int n) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (matrix[i][mid] <= num)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            count += l;
            if (l == 0)
                break;
        }
        return count;
    }
}
