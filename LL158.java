public class LL158 {
    static class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node reverseDLL(Node head) {
        // Your code here
        Node lo = head, curr = head.next, hi = curr.next;
        while (curr != null) {
            lo.next = hi;
            hi.prev = lo;

            curr.next = lo;
            lo.prev = curr;
            curr.prev = null;

            lo = curr;
            curr = hi;
            hi = curr.next;
        }
        return lo;
    }
}
