public class LL141 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    public static boolean detectLoop(Node head) {
        // Add code here
        Node slow = head, fast = head;
        while (fast != null && fast.next != null) {
            if (fast.next == slow || fast.next.next == slow)
                return true;
            fast = fast.next.next;
            slow = slow.next;
        }
        return false;
    }
}
