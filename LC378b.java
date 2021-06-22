import java.util.PriorityQueue;

public class LC378b {
    public static class cell implements Comparable<cell> {
        int x, y, num;

        cell(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }

        @Override
        public int compareTo(cell o) {
            return this.num - o.num;
        }
    }

    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<cell> pq = new PriorityQueue<>();
        for (int i = 0, j = 0; j < n; j++) {
            pq.add(new cell(i, j, matrix[i][j]));
        }

        int ans = -1;
        while (k-- > 0 && !pq.isEmpty()) {
            cell no = pq.poll();
            if (no.x < n - 1)
                pq.add(new cell(no.x + 1, no.y, matrix[no.x + 1][no.y]));

            ans = no.num;
        }
        return ans;
    }
}
