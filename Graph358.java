import java.util.ArrayList;

public class Graph358 {
    public static ArrayList<Integer> list;

    public static void DFS(ArrayList<ArrayList<Integer>> adj, boolean[] visited, int v){
        visited[v]= true;
        list.add(v);

        for (int i=0;i<adj.get(v).size();i++){
            if (!visited[adj.get(v).get(i)]){
                DFS(adj, visited, adj.get(v).get(i));
            }
        }
    }
    public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited= new boolean[V];
        list= new ArrayList<>();
        DFS(adj, visited, 0);
        return list;
    }

    public static void main(String[] args) throws Exception{
        ArrayList<ArrayList<Integer>> graph= new ArrayList<ArrayList<Integer>>();

        int vertices= 7;
        for(int i=0;i<vertices;i++){
            graph.add(new ArrayList<Integer>());
        }

        addEdge(graph, 0, 1);
        addEdge(graph, 0, 2);
        addEdge(graph, 0, 3);
        addEdge(graph, 1, 2);

        ArrayList<Integer> ans= dfsOfGraph(vertices, graph);
        System.out.println(ans);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}
