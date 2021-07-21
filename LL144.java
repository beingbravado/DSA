import java.util.HashSet;

public class LL144 {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public Node removeDuplicates(Node head) {
        // Your code here
        HashSet<Integer> set = new HashSet<>();
        Node x = head;
        set.add(x.data);
        while (x != null && x.next != null) {
            if (set.contains(x.next.data)) {
                x.next = x.next.next;
                continue;
            } else
                set.add(x.next.data);
            x = x.next;
        }
        return head;
    }
}
