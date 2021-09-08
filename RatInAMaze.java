import java.util.ArrayList;

public class RatInAMaze {
    static ArrayList<String> ans;

    public static ArrayList<String> findPath(int[][] maze, int n) {
        // Your code here
        ans = new ArrayList<String>();
        boolean[][] visited = new boolean[n][n];
        backtrack(maze, visited, "", n, 0, 0);
        return ans;

    }

    public static void backtrack(int[][] a, boolean[][] visited, String path, int n, int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n || visited[x][y] || a[x][y] == 0)
            return;

        if (x == n - 1 && y == n - 1) {
            ans.add(path);
            return;
        }
        visited[x][y] = true;

        backtrack(a, visited, path + "D", n, x + 1, y);
        backtrack(a, visited, path + "R", n, x, y + 1);
        backtrack(a, visited, path + "U", n, x - 1, y);
        backtrack(a, visited, path + "L", n, x, y - 1);

        visited[x][y] = false;
    }
}
