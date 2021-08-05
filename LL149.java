public class LL149 {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static int intersectPoint(Node head1, Node head2) {
        int intersection = -1;
        int lh1 = 0, lh2 = 0;
        Node ptr = head1;
        while (ptr != null) {
            ptr = ptr.next;
            lh1++;
        }
        ptr = head2;
        while (ptr != null) {
            ptr = ptr.next;
            lh2++;
        }
        int dif = lh1 - lh2;

        if (dif != 0) {
            while (dif > 0) {
                head1 = head1.next;
                dif--;
            }
            while (dif < 0) {
                head2 = head2.next;
                dif++;
            }
        }
        boolean ans = true;
        while (head1 != null && head2 != null) {
            if (head1 == head2 && ans) {
                intersection = head1.data;
                ans = false;
            } else if (head1 != head2 && !ans) {
                intersection = -1;
                ans = true;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return intersection;
    }
}
