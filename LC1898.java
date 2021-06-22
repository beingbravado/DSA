public class LC1898 {
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(s, p, removable, mid))
                l = mid + 1;
            else
                r = mid - 1;
        }
        return l;
    }

    public static boolean check(String s, String p, int[] removable, int mid) {
        boolean[] leave = new boolean[s.length()];
        for (int i = 0; i <= mid; i++)
            leave[removable[i]] = true;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (leave[i])
                continue;
            if (p.charAt(index) == s.charAt(i))
                index++;
            if (index == p.length())
                return true;
        }
        return false;
    }
}
