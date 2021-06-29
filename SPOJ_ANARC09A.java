import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class SPOJ_ANARC09A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        String s = br.readLine().trim();
        int t = 0;
        while (s.charAt(0) != '-') {
            Stack<Character> stack = new Stack<>();
            int ans = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{')
                    stack.pop();
                else
                    stack.push(s.charAt(i));
            }
            while (!stack.isEmpty()) {
                char x = stack.pop();
                if (x == '{') {
                    x = '}';
                    ans++;
                }
                char y = stack.pop();
                if (y == '}') {
                    y = '{';
                    ans++;
                }
            }
            s = br.readLine().trim();
            sb.append(++t + ". " + ans + "\n");
        }
        System.out.println(sb);
        br.close();
    }
}
