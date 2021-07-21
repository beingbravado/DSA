public class LL147 {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    public static Node addOne(Node head) {
        // code here.
        if (addNumber(head) > 0) {
            Node newHead = new Node(1);
            newHead.next = head;
            return newHead;
        }
        return head;
    }

    public static int addNumber(Node head) {
        // code here.
        if (head.next == null) {
            head.data++;
            if (head.data == 10) {
                head.data = 0;
                return 1;
            }
            return 0;
        }
        int carry = addNumber(head.next);
        if (carry > 0) {
            if (head.data == 9) {
                head.data = 0;
            } else {
                head.data++;
                carry = 0;
            }
        }
        return carry;
    }
}
