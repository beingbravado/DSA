import java.util.ArrayList;
import java.util.Scanner;

public class RatInMaze1 {
    static ArrayList<String> paths;

    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        boolean[][] vis = new boolean[n][n];
        paths = new ArrayList<>();
        findingPath(m, vis, n, 0, 0, "");
        return paths;
    }

    public static void findingPath(int[][] maze, boolean[][] vis, int n, int x, int y, String path) {
        if (x < 0 || y < 0 || x == n || y == n)
            return;
        if (vis[x][y] || maze[x][y] == 0)
            return;
        if (x == n - 1 && y == n - 1) {
            paths.add(path);
            return;
        }
        vis[x][y] = true;
        findingPath(maze, vis, n, x + 1, y, path + "D");
        findingPath(maze, vis, n, x, y - 1, path + "L");
        findingPath(maze, vis, n, x, y + 1, path + "R");
        findingPath(maze, vis, n, x - 1, y, path + "U");
        vis[x][y] = false;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] maze = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                maze[i][j] = scan.nextInt();
        }

        System.out.println(findPath(maze, n));
        scan.close();
    }
}
