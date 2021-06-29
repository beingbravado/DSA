public class LOC856 {
    public int scoreOfParentheses(String s) {
        int ans = 0, level = 0;
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);
            if (x == '(')
                level++;
            else {
                level--;
                if (s.charAt(i - 1) == '(')
                    ans += Math.pow(2, level);
            }
        }
        return ans;
    }
}
