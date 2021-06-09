public class NumberofIslands {
    static int[] dx = { 0, 0, 1, -1, 1, 1, -1, -1 };
    static int[] dy = { 1, -1, 0, 0, 1, -1, 1, -1 };

    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    island(grid, visited, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void island(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || visited[x][y] || grid[x][y]=='0')
            return;
        visited[x][y] = true;
        for (int i = 0; i < 8; i++)
            island(grid, visited, x + dx[i], y + dy[i]);
    }
}
