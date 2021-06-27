import java.util.HashMap;
public class LC1748 {
    public int sumOfUnique(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
        }
        for (Integer node : hm.keySet()) {
            ans += hm.get(node) == 1 ? node : 0;
        }
        return ans;
    }
}
