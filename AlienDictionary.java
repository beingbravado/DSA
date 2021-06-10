import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AlienDictionary {
    public String findOrder(String[] dict, int n, int k) {
        // Write your code here
        StringBuilder sb = new StringBuilder();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < k; i++)
            graph.add(new ArrayList<>());
        Stack<Integer> s = new Stack<>();
        for (int i = 1; i < n; i++) {
            int x = -1, y = -1;
            for (int j = 0; j < dict[i].length() && j < dict[i - 1].length(); j++) {
                if (dict[i].charAt(j) != dict[i - 1].charAt(j)) {
                    x = dict[i].charAt(j) - 'a';
                    y = dict[i - 1].charAt(j) - 'a';
                    graph.get(x).add(y);
                }
            }
        }
        boolean[] vis = new boolean[k];
        for (int i = 0; i < k; i++) {
            if (!vis[i]) {
                helper(graph, vis, s, i);
            }
        }
        for (int i = 0; i < k; i++) {
            sb.append('a' + s.pop());
        }
        return sb.toString();
    }

    public static void helper(List<List<Integer>> graph, boolean[] vis, Stack<Integer> s, int node) {
        if (vis[node])
            return;
        vis[node] = true;

        for (int x : graph.get(node))
            helper(graph, vis, s, x);
        s.add(node);
    }
}
