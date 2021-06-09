import java.io.*;
import java.util.*;

public class Labyrinth {
    static int distance;
    static String path;

    public static class pair {
        int x, y;
        String str;

        pair(int x, int y, String str) {
            this.x = x;
            this.y = y;
            this.str = str;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        char[][] graph = new char[n][m];
        boolean[][] visited = new boolean[n][m];
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            String s2 = br.readLine();
            for (int j = 0; j < m; j++) {
                graph[i][j] = s2.charAt(j);
                if (graph[i][j] == 'A') {
                    x = i;
                    y = j;
                }
            }
        }
        // System.out.println("x: " + x + " y: " + y);
        distance = n * m;
        labyrinth(graph, visited, x, y);
        if (distance >= n * m)
            System.out.println("NO");
        else
            System.out.println("YES\n" + distance + "\n" + path);
        br.close();
    }

    public static void labyrinth(char[][] graph, boolean[][] visited, int x, int y) {
        int n = graph.length;
        int m = graph[0].length;
        Queue<pair> q = new LinkedList<>();
        int[] xx = { 1, 0, -1, 0 };
        int[] yy = { 0, 1, 0, -1 };
        String[] c = { "D", "R", "U", "L" };
        q.add(new pair(x, y, ""));
        q.add(null);
        int level = 0;
        while (!q.isEmpty()) {
            // System.out.println("inside while loop");
            pair p = q.poll();
            if (p == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    level++;
                }
                continue;
            }
            visited[p.x][p.y] = true;
            // System.out.println(p.x + " " + p.y + " " + p.str);
            if (graph[p.x][p.y] == 'B') {
                distance = level;
                path = p.str;
                // System.out.println("value assigned");
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = p.x + xx[i], my = p.y + yy[i];
                // System.out.println(nx + " + " + my);
                if ((nx >= 0) && (nx < n) && (my >= 0) && (my < m)) {
                    if (graph[nx][my] != '#' && !visited[nx][my]) {
                        q.add(new pair(nx, my, p.str + c[i]));
                        // System.out.println("accepted : " + nx + " " + my + " " + p.str);
                    }
                }
            }
        }
    }
}
