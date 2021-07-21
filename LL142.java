public class LL142 {
    class Node {
        int data;
        Node next;
    }

    public static void removeLoop(Node head) {
        // code here
        // remove the loop without losing any nodes
        Node low = head, high = head;
        while (low.next != null && high != null && high.next != null) {
            low = low.next;
            high = high.next.next;
            if (high == low)
                break;
        }

        if (low == head && low == high) {
            while (high.next != low) {
                high = high.next;
            }
            high.next = null;
        } else if (low == high) {
            low = head;
            while (high.next != low.next) {
                high = high.next;
                low = low.next;
                if (low.next == high.next)
                    break;
            }
            high.next = null;
        }
    }
}
