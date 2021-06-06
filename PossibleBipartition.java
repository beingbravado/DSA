import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PossibleBipartition {
    public static boolean possibleBipartition(int n, int[][] dislikes) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            graph.add(new ArrayList<Integer>());
        for (int i = 0; i < dislikes.length; i++) {
            graph.get(dislikes[i][0]).add(dislikes[i][1]);
            graph.get(dislikes[i][1]).add(dislikes[i][0]);
        }
        int[] visited = new int[n + 1];
        Arrays.fill(visited, -1);
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (visited[i] < 0) {
                q.add(i);
                q.add(null);
                int level = 0;

                while (!q.isEmpty()) {
                    Integer x = q.poll();
                    if (x == null) {
                        if (!q.isEmpty()) {
                            q.add(null);
                            level++;
                            continue;
                        } else
                            break;
                    }
                    if (visited[x] >= 0) {
                        if (Math.abs(level - visited[x]) % 2 != 0)
                            return false;
                        continue;
                    } else
                        visited[x] = level;

                    for (int y : graph.get(x))
                        q.add(y);
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] dislikes = new int[m][2];
        System.out.println(possibleBipartition(n, dislikes));
        scan.close();
    }
}
