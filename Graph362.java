import java.util.ArrayList;
import java.util.Scanner;

public class Graph362 {
    public static int ans;

    public static void minStep(int kx, int ky, int tx, int ty, boolean[][] visited, int n, int steps) {
        // Code here
        if (kx >= n || ky >= n || kx < 0 || ky < 0 || visited[kx][ky])
            return;

        if (kx == tx && ky == ty) {
            ans = Math.min(ans, steps);
            return;
        }

        int[] x = { 2, 2, -2, -2, 1, 1, -1, -1 };
        int[] y = { 1, -1, 1, -1, 2, -2, 2, -2 };
        visited[kx][ky] = true;
        for (int i = 0; i < 8; i++) {
            minStep(kx + x[i], ky + y[i], tx, ty, visited, n, steps + 1);
        }
        visited[kx][ky] = false;
    }

    public static int minStepToReachTarget(int KnightPos[], int TargetPos[], int n) {
        // Code here
        int ans = n*n;
        System.out.println(ans);
        boolean[][] visited = new boolean[n + 1][n + 1];
        int steps = 0;
        int kx = KnightPos[0] - 1, ky = KnightPos[1] - 1;
        int tx = TargetPos[0] - 1, ty = TargetPos[1] - 1;
        minStep(kx, ky, tx, ty, visited, n, steps);
        return ans;
    }

    public static void main(String[] args) throws Exception {
        // ArrayList<ArrayList<Integer>> graph= new ArrayList<>();

        Scanner scan = new Scanner(System.in);
        // int vertices= scan.nextInt();
        // int edges= scan.nextInt();
        // for(int i=0;i<vertices;i++){
        // graph.add(new ArrayList<Integer>());
        // }

        // for (int i=0;i<edges;i++){
        // addEdge(graph, scan.nextInt(), scan.nextInt());
        // }

        // boolean ans= isCycle(vertices, graph);
        // System.out.println(ans);

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

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int x, int y) {
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}
