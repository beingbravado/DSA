import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class permutation {
    static List<String> res;

    public List<String> find_permutation(String s) {
        // Code here
        res = new ArrayList<>();
        int n = s.length();
        permute(s, 0, n);
        Collections.sort(res);
        return res;
    }

    public static void permute(String s, int i, int length) {
        System.out.println(s);
        if (i >= length)
            return;
        if (i == length - 1) {
            res.add(s);
            return;
        }
        for (int j = i + 1; j <= length; j++)
            permute(swap(s, i, j), i + 1, length);
    }

    static String swap(String str, int i, int j) {
        if (i >= str.length() || j >= str.length())
            return str;
        if (i == j)
            return str;
        if (j == str.length() - 1)
            return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i);

        return str.substring(0, i) + str.charAt(j) + str.substring(i + 1, j) + str.charAt(i)
                + str.substring(j + 1, str.length());
    }
}