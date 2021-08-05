import java.util.HashMap;

public class LC3 {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0)
            return 0;
        char[] x = s.toCharArray();
        int count = 0, last = -1;
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int c = x[i];
            last = Math.max(last, set.getOrDefault(c, -1));
            count = Math.max(count, i - last);
            set.put(c, i);
        }
        return count;
    }
}
