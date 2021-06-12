import java.util.Scanner;

public class NegativeWeightCycle {

    public static int isNegativeWeightCycle(int n, int[][] edges) {
        // code here
        int[] dist = new int[n];
        for (int i = 1; i < n; i++) {
            traverse(edges, dist);
        }
        int[] check = new int[n];
        for (int i = 0; i < n; i++)
            check[i] = dist[i];
        traverse(edges, dist);
        for (int i = 0; i < n; i++) {
            // System.out.println(check[i] + " " + dist[i]);
            if (dist[i] != check[i])
                return 1;
        }
        return 0;
    }

    public static void traverse(int[][] edges, int[] dist) {
        for (int i = 0; i < edges.length; i++) {
            dist[edges[i][1]] = dist[edges[i][0]] + edges[i][2];
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] edges = new int[m][3];
        for (int i = 0; i < m; i++) {
            edges[i][0] = scan.nextInt();
            edges[i][1] = scan.nextInt();
            edges[i][2] = scan.nextInt();
        }
        System.out.println(isNegativeWeightCycle(n, edges));
        scan.close();
    }
}
