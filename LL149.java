public class LL149 {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static Node findIntersection(Node head1, Node head2) {
        // code here.
        Node intersection = new Node(0);
        Node ans = intersection;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                Node x = new Node(head1.data);
                intersection.next = x;
                intersection = intersection.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data)
                head1 = head1.next;
            else
                head2 = head2.next;
        }
        return ans.next;
    }
}
