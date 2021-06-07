import java.io.*;
import java.util.*;

public class RoundTrip {
    static int result = Integer.MAX_VALUE;
    static String s = "";

    public static class pair {
        int node, parent;

        pair(int x, int y) {
            node = x;
            parent = y;
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        ArrayList<ArrayList<pair>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            graph.get(a).add(new pair(b, a));
            graph.get(b).add(new pair(a, b));
        }
        boolean[] visited = new boolean[n + 1];
        // boolean[] using = new boolean[n + 1];
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            trip(graph, visited, new pair(i, 0), "", 0, flag);
        }
        if (result < Integer.MAX_VALUE && result > 3) {
            System.out.println(result);
            System.out.println(s);
        } else {
            System.out.println("IMPOSSIBLE");
        }
        scan.close();
    }

    public static void trip(ArrayList<ArrayList<pair>> graph, boolean[] visited, pair node, String path, int ans,
            boolean flag) {
        if (visited[node.node]) {
            if (result > ans + 1) {
                result = ans + 1;
                s = path + node.node;
            }
            flag = true;
            return;
        }
        visited[node.node] = true;
        // using[node] = true;
        for (pair x : graph.get(node.node)) {
            if (x.node != node.parent)
                trip(graph, visited, x, path + node.node + " ", ans + 1, flag);
        }
        visited[node.node] = false;
    }
}