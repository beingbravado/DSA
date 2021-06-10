import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    static int[] topoSort(int v, ArrayList<ArrayList<Integer>> graph) {
        // add your code here
        int[] ans = new int[v];
        Stack<Integer> s = new Stack<>();
        boolean[] vis = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (!vis[i]) {
                helper(graph, vis, s, i);
            }
        }
        for (int i = 0; i < v; i++)
            ans[i] = s.pop();
        return ans;
    }

    public static void helper(ArrayList<ArrayList<Integer>> graph, boolean[] vis, Stack<Integer> s, int node) {
        if (vis[node])
            return;
        vis[node] = true;

        for (int x : graph.get(node)) {
            helper(graph, vis, s, x);
        }
        s.add(node);
    }
}
