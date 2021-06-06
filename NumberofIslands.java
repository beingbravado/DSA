public class NumberofIslands {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    boolean con = true;
                    if (grid[i][j] == (i == 0 ? '0' : grid[i - 1][j]))
                        con = false;
                    if (grid[i][j] == (j == 0 ? '0' : grid[i][j - 1]))
                        con = false;
                    if (grid[i][j] == (i == m - 1 ? '0' : grid[i + 1][j]))
                        con = false;
                    if (grid[i][j] == (j == n - 1 ? '0' : grid[i][j + 1]))
                        con = false;
                    if (con)
                        ans++;
                }
            }
        }
        return ans;
    }
}
