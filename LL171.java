public class LL171 {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    Node compute(Node head) {
        Node ptr = reverse(head);
        Node prev = ptr, forw = ptr.next;
        while (forw != null) {
            if (prev.data > forw.data) {
                prev.next = forw.next;
                forw = forw.next;
            } else {
                prev = forw;
                forw = forw.next;
            }
        }
        return reverse(ptr);
    }

    static Node reverse(Node head) {
        Node first = head, last = head.next;
        while (last != null) {
            head.next = last.next;
            last.next = first;

            first = last;
            last = head.next;
        }
        return first;
    }
}
