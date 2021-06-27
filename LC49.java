import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LC49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = makeCode(strs[i]);
            System.out.println(s);
            if (!map.containsKey(s))
                map.put(s, new ArrayList<>());
            map.get(s).add(strs[i]);
        }
        for (String s : map.keySet()) {
            ans.add(map.get(s));
        }
        return ans;
    }

    public static String makeCode(String s) {
        StringBuilder sb = new StringBuilder();
        int[] arr = new int[26];
        char a = 'a';
        for (int c = 0; c < s.length(); c++)
            arr[s.charAt(c) - a]++;
        for (int x = 0; x < arr.length; x++)
            if (arr[x] > 0)
                sb.append((char) (a + x) + "" + arr[x] + " ");
        return sb.toString();
    }
}
