import java.util.*;

public class Graph362 {
    public static class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean valid(boolean[][] visited, pair knight) {
        int n = visited.length;
        if (knight.x <= 0 || knight.x >= n || knight.y <= 0 || knight.y >= n)
            return false;
        if (visited[knight.x][knight.y])
            return false;
        return true;
    }

    public static int minStep(pair k, pair t, boolean[][] visited, int steps) {
        Queue<pair> q = new LinkedList<>();
        q.add(k);
        q.add(null);
        while (!q.isEmpty()) {
            pair p = q.poll();
            if (p == null) {
                if (!q.isEmpty()) {
                    q.add(null);
                    steps++;
                }
                continue;
            }

            if ((p.x == t.x && p.y == t.y))
                return steps;

            visited[p.x][p.y] = true;
            int[] x = { 2, 2, -2, -2, 1, 1, -1, -1 };
            int[] y = { 1, -1, 1, -1, 2, -2, 2, -2 };
            for (int i = 0; i < 8; i++) {
                pair check = new pair(p.x + x[i], p.y + y[i]);
                if (valid(visited, check))
                    q.add(check);
            }
        }
        return -1;
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int n) {
        // Code here
        boolean[][] visited = new boolean[n+1][n+1];
        return minStep(new pair(KnightPos[0], KnightPos[1]), new pair(TargetPos[0], TargetPos[1]),
                visited, 0);
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] KnightPos = new int[2];
        int[] TargetPos = new int[2];
        KnightPos[0] = scan.nextInt();
        KnightPos[1] = scan.nextInt();
        TargetPos[0] = scan.nextInt();
        TargetPos[1] = scan.nextInt();
        System.out.println(minStepToReachTarget(KnightPos, TargetPos, n));
        scan.close();
    }
}
