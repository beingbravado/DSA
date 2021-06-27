import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Queue;

public class LC347 {
    public static class pair implements Comparable<pair> {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(pair o) {
            return this.y - o.y;
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Queue<pair> pq = new PriorityQueue<>();
        for (int x : map.keySet()) {
            pq.add(new pair(x, map.get(x)));
            if (pq.size() > k)
                pq.poll();
        }
        for (int i = 0; i < k; i++)
            ans[i] = pq.poll().x;
        return ans;
    }
}
