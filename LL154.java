public class LL154 {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    boolean isCircular(Node head) {
        // Your code here
        Node x = head;
        boolean ans = false;
        while (x != null) {
            if (x.next == head) {
                ans = true;
                break;
            }
            x = x.next;
        }
        return ans;
    }
}
