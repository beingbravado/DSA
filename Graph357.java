import java.util.*;

public class Graph357 {
    public static ArrayList<Integer> bfsOfGraph(int v,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<Integer> q= new LinkedList<>();
        boolean[] visited= new boolean[v];
        q.add(0);
        visited[0]= true;


        while (!q.isEmpty()){
            int x= q.poll();
            ans.add(x);
            for (int i=0;i< adj.get(x).size(); i++){
                if (!visited[adj.get(x).get(i)]) {
                    q.add(adj.get(x).get(i));
                    visited[adj.get(x).get(i)]= true;
                }
            }
        }

        return ans;
    }
    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
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

        ArrayList<Integer> ans= bfsOfGraph(vertices, graph);
        System.out.println(ans);
    }
}
