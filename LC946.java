import java.util.Stack;

public class LC946 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> s = new Stack<>();
        s.push(-1);
        int y = 0;
        for (int x : pushed) {
            s.push(x);
            while (y < popped.length && s.peek() == popped[y]) {
                s.pop();
                y++;
            }
        }
        return y == popped.length;
    }
}