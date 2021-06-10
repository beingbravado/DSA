import java.util.ArrayList;
import java.util.List;

public class MaximalNetworkRank {
    static int count;

    public int maximalNetworkRank(int n, int[][] roads) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < roads.length; i++) {
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    network(graph, i, j);
                    ans = Math.max(ans, count);
                }
            }
        }
        return ans;
    }

    public static void network(List<List<Integer>> graph, int x, int y) {
        count = graph.get(x).size() + graph.get(y).size();

        for (int p : graph.get(y)) {
            if (p == x)
                count--;
        }
    }
}
