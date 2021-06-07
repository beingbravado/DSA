import java.io.*;
import java.util.*;

public class CountingRooms {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        String[] s1= br.readLine().trim().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++){
            String s2= br.readLine().trim();
            grid[i]= s2.toCharArray();
        }
        int ans = 0;
        boolean[][] visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '.' && !visited[i][j]) {
                    findGraphs(grid, visited, ans, i, j);
                    ans++;
                }
                // System.out.print(ans + " ");
            }
            // System.out.println();
        }
        System.out.println(ans);
        scan.close();
    }

    public static void findGraphs(char[][] grid, boolean[][] visited, int ans, int x, int y) {
        visited[x][y] = true;
        if (condition(grid, visited, x - 1, y))
            findGraphs(grid, visited, ans, x - 1, y);
        if (condition(grid, visited, x, y - 1))
            findGraphs(grid, visited, ans, x, y - 1);
        if (condition(grid, visited, x + 1, y))
            findGraphs(grid, visited, ans, x + 1, y);
        if (condition(grid, visited, x, y + 1))
            findGraphs(grid, visited, ans, x, y + 1);
    }

    public static boolean condition(char[][] grid, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x == grid.length || y == grid[0].length)
            return false;
        if (visited[x][y] || grid[x][y] == '#')
            return false;
        return true;
    }
}
