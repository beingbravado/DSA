import java.util.*;

public class ishika {
    public static int topologytype(int n, int m, int[] a, int[] b) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            graph.get(a[i]).add(b[i]);
            // graph.get(b[i]).add(a[i]);
        }

        int ans = 1;
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> q = new LinkedList<>();
        visited[1] = true;
        q.add(1);
        while (!q.isEmpty()) {
            int node = q.poll();
            if (graph.get(node).size() > 1)
                ans = 2;
            for (int x : graph.get(node)) {
                q.add(x);
                if (visited[x]) {
                    ans = 3;
                    return 3;
                }
                visited[x] = true;
            }
        }
        return ans;
    }
}
