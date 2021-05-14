import java.util.ArrayList;
import java.util.Scanner;

public class Graph359 {
    static boolean solution= false;
    public static void solution(ArrayList<ArrayList<Integer>> graph, int x, boolean[] visited, boolean[] track){
        if (visited[x]){
            solution= true;
            return;
        }
        if (track[x]) return;

        visited[x]= true; track[x]= true;
        for (int i=0;i< graph.get(x).size(); i++){
            solution(graph, graph.get(x).get(i), visited, track);
        }
        visited[x]= false;
    }
    public static boolean isCyclic(int V, ArrayList<ArrayList<Integer>> graph)
    {
        // code here
        solution= false;
        boolean[] visited= new boolean[V];
        boolean[] track= new boolean[V];
        for (int i=0;i< V;i++){
            solution(graph,i, visited, track);
            if (solution) break;
        }
        return solution;
    }
    public static void main(String[] args) throws Exception{
        ArrayList<ArrayList<Integer>> graph= new ArrayList<>();

        Scanner scan= new Scanner(System.in);
        int vertices= scan.nextInt();
        int edges= scan.nextInt();
        for(int i=0;i<vertices;i++){
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0;i<edges;i++){
            addEdge(graph, scan.nextInt(), scan.nextInt());
        }

        boolean ans= isCyclic(vertices, graph);
        System.out.println(ans);
//        System.out.println(graph.size());
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
//        graph.get(y).add(x);
    }
}
