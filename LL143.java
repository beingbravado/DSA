public class LL143 {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    Node removeDuplicates(Node head) {
        // Your code here
        Node x = head;
        while (x != null && x.next != null) {
            if (x.data == x.next.data) {
                x.next = x.next.next;
                continue;
            }
            x = x.next;
        }
        return head;
    }
}
