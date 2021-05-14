import java.util.ArrayList;
import java.util.Scanner;

public class Graph361 {
    public static ArrayList<String> list;
    public static void paths(int[][] maze, boolean[][] visited, int n, int x, int y, String s) {
        // Your code here
        if (x<0 || y<0 || x==n || y==n) return;
        if (visited[x][y]) return;

        if (x==n-1 && y== n-1){
            list.add(s);
            return;
        }

        visited[x][y]= true;
        paths(maze, visited, n, x+1, y, s+'D');
        paths(maze, visited, n, x, y-1, s+'L');
        paths(maze, visited, n, x, y+1, s+'R');
        paths(maze, visited, n, x-1, y, s+'U');
        visited[x][y]= false;
    }
    public static ArrayList<String> findPath(int[][] maze, int n) {
        // Your code here
        list= new ArrayList<>();
        String s="";
        boolean[][] visited= new boolean[n][n];
        for (int i = 0; i < n; i++) for (int j = 0; j < n; j++) if (maze[i][j]==0) visited[i][j]= true;
        paths(maze,visited ,n,0,0, s);
        return list;
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

//        boolean ans= isCycle(vertices, graph);
//        System.out.println(ans);
        System.out.println(graph);
    }

    public static void addEdge(ArrayList<ArrayList<Integer>> graph, int x, int y){
        graph.get(x).add(y);
        graph.get(y).add(x);
    }
}
