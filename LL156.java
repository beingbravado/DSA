public class LL156 {
    static class Node {
        int data;
        Node next;

        Node(int d) {
            data = d;
            next = null;
        }
    }

    boolean isPalindrome(Node head) {
        // Your code here
        if (head == null || head.next == null)
            return true;

        boolean ans = true;
        int length = 0;
        Node temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        Node mid = head, midBack = null;
        for (int i = 0; i < length / 2; i++) {
            midBack = mid;
            mid = mid.next;
        }

        Node last = reverse(mid);
        Node x = head, y = last;
        mid.next = null;
        while (x != null && y != null) {
            if (x.data != y.data) {
                ans = false;
                break;
            }
            x = x.next;
            y = y.next;
        }

        midBack.next = reverse(last);
        return ans;
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
