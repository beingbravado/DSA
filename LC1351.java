public class LC1351 {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            int l = 0, r = grid[0].length - 1;
            while (l <= r) {
                int mid = (l + r) / 2;
                if (grid[i][mid] >= 0)
                    l = mid + 1;
                else
                    r = mid - 1;
            }
            ans += grid[0].length - l;
        }
        return ans;
    }
}
