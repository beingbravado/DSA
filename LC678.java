import java.util.Stack;

public class LC678 {
    public boolean checkValidString(String s) {
        Stack<Character> stq = new Stack<>();
        int star = 0;
        for (char c : s.toCharArray()) {
            if (c != ')') {
                stq.add(c);
            } else {
                if (stq.size() == 0)
                    return false;
                if (stq.peek() == '*')
                    star += 2;
                stq.pop();
            }
        }
        int brac = 0;
        for (char x : stq) {
            if (x == '(')
                brac++;
            else
                star++;
        }
        if (star >= brac)
            return true;
        return false;
    }
}