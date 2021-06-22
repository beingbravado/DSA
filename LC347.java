import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LC347 {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        HashMap<Integer, ArrayList<Integer>> freq = new HashMap<>();
        int[] ans = new int[k];

        return ans;
    }
}
