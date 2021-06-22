import java.util.LinkedList;
import java.util.Queue;

public class LC5791 {
    static boolean flag;

    public static class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int ans = 0;
        boolean[][] vis = new boolean[grid1.length][grid1[0].length];
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid2[i][j] == 1 && !vis[i][j]) {
                    flag= true;
                    traverse(grid1, grid2, vis, i, j);
                    if(flag)
                        ans++;
                }
            }
        } 
        return ans;
    }

    public static void traverse(int[][] grid1, int[][] grid2, boolean[][] vis, int x, int y) {
        int m = grid1.length, n = grid1[0].length;
        Queue<pair> q = new LinkedList<>();
        int[] dx = { 1, 0, -1, 0 };
        int[] dy = { 0, 1, 0, -1 };
        q.add(new pair(x, y));
        while (!q.isEmpty()) {
            pair p = q.poll();
            if (grid1[p.x][p.y] == 0){
                flag= false;
                continue;
            }
            vis[p.x][p.y] = true;
            for (int i = 0; i < 4; i++) {
                if ((p.x + dx[i]) >= 0 && (p.y + dy[i]) >= 0 && (p.x + dx[i]) < m && (p.y + dy[i]) < n) {
                    if (grid2[p.x + dx[i]][p.y + dy[i]] == 1 && !vis[p.x + dx[i]][p.y + dy[i]])
                        q.add(new pair(p.x + dx[i], p.y + dy[i]));
                }
            }
        }
    }
}
