import java.util.*;

public class ReduceArraySizeToHalf {
    public static class pair {
        int num, count;

        pair(int x, int y) {
            num = x;
            count = y;
        }
    }

    public int minSetSize(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        Queue<pair> pq = new PriorityQueue<>(arr.length, (a, b) -> b.count - a.count);
        for (int x : map.keySet()) {
            pq.add(new pair(x, map.get(x)));
        }

        int count = 0, ans = 0;
        while (!pq.isEmpty()) {
            pair p = pq.poll();
            ans++;
            count += p.count;
            if (count * 2 >= arr.length)
                break;
        }

        return ans;
    }
}
