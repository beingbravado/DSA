import java.util.ArrayList;

public class Graph356 {
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

        printGraph(graph);
    }
    public static void printGraph(ArrayList<ArrayList<Integer>> graph){
        for (int i=0;i< graph.size();i++){
            System.out.println("\nVertex " + i + ":");
            for (int j=0;j< graph.get(i).size();j++){
                System.out.print(" -> " + graph.get(i).get(j));
            }
            System.out.println();
        }
    }
}
