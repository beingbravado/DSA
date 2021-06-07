import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class BuildingRoads {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().trim().split(" ");
        int n = Integer.parseInt(s1[0]);
        int m = Integer.parseInt(s1[1]);
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            String[] s2 = br.readLine().trim().split(" ");
            int a = Integer.parseInt(s2[0]);
            int b = Integer.parseInt(s2[1]);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        boolean[] visited = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        visit(graph, visited, 1);
        int ans=0;
        for(int i=2;i<=n;i++){
            if(!visited[i]){
                ans++;
                visit(graph, visited, i);
                sb.append((i-1)+" "+i+"\n");
            }
        }
        System.out.println(ans);
        System.out.println(sb);
        scan.close();
    }

    public static void visit(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int node){
        if(visited[node]) return;
        visited[node]= true;
        for(int x: graph.get(node)){
            visit(graph, visited, x);
        }
    }
}
