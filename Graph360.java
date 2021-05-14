import java.util.ArrayList;
import java.util.Scanner;

public class Graph360 {
    static boolean solution= false;
    public static void checkCycle(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int x, int parent){
        if (!visited[x]){
            visited[x]=true;
            for (int i=0;i<graph.get(x).size();i++) checkCycle(graph, visited, graph.get(x).get(i), x);
            visited[x]= false;
        } else if (x!=parent) solution= true;
    }
    public static boolean isCycle(int vertices, ArrayList<ArrayList<Integer>> graph)
    {
        // Code here
        boolean[] visited= new boolean[vertices];
        solution= false;
        int parent = -1;
        for (int i=0;i<vertices;i++) {
            checkCycle(graph, visited, i, parent);
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

        boolean ans= isCycle(vertices, graph);
        System.out.println(ans);
        System.out.println(graph);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}
