import java.util.HashSet;
import java.util.List;
import java.util.Vector;

public class WordLadder {
    public static class pair {
        int length;
        String str;

        pair(int x, String s) {
            length = x;
            str = s;
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for (String s : wordList) {
            set.add(s);
        }
        Vector<pair> v = new Vector<>();
        v.add(new pair(1, beginWord));
        while (!v.isEmpty()) {
            pair p = v.elementAt(0);
            v.remove(0);

            if (p.str.equals(endWord))
                return p.length;

            for (int i = 0; i < p.str.length(); i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    String s = p.str.substring(0, i) + c + p.str.substring(i + 1);
                    if (set.contains(s)) {
                        v.add(new pair(p.length + 1, s));
                        set.remove(s);
                    }
                }
            }
        }
        return 0;
    }
}
