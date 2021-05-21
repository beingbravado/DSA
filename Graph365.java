import java.util.ArrayList;

public class Graph365 {
    public static int makeConnected(int n, int[][] connections) {

        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < connections.length; i++) {
            graph[connections[i][0]].add(connections[i][1]);
            graph[connections[i][1]].add(connections[i][0]);
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        if (n - 1 > connections.length)
            ans = -1;
        else {
            connected(graph, visited, 0);
            for (int i = 1; i < n; i++) {
                if (!visited[i]) {
                    ans++;
                    connected(graph, visited, i);
                }
            }
        }
        return ans;
    }

    public static void connected(ArrayList<Integer>[] graph, boolean[] visited, int node) {
        if (visited[node])
            return;
        visited[node] = true;
        for (int x : graph[node]) {
            connected(graph, visited, x);
        }
    }
}
