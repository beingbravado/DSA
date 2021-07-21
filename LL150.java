public class LL150 {
    class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    int intersectPoint(Node head1, Node head2) {
        // code here
        int ans = -1;
        Node x = head1;
        while (x.next != null)
            x = x.next;
        x.next = head1;

        Node lo = head2, hi = head2;
        while (lo != null && hi != null && hi.next != null) {
            if (lo == hi)
                break;
            lo = lo.next;
            hi = hi.next.next;
        }
        if (lo == hi) {
            lo = head2;
            if (hi != head2) {
                while (hi != lo) {
                    lo = lo.next;
                    hi = hi.next;
                }
            }
            ans= hi.data;
        }
        x.next = null;
        return ans;
    }
}
