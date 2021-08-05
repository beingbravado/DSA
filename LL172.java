public class LL172 {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    Node divide(int N, Node head) {
        // code here
        Node even = new Node(-1), odd = new Node(-1);
        Node evenPtr = even, oddPtr = odd;
        Node ptr = head;
        while (ptr != null) {
            if (ptr.data % 2 == 0) {
                evenPtr.next = ptr;
                evenPtr = evenPtr.next;
            } else {
                oddPtr.next = ptr;
                oddPtr = oddPtr.next;
            }
            ptr = ptr.next;
        }
        evenPtr.next = null;
        oddPtr.next = null;

        if (even.next != null) {
            head = even.next;
            evenPtr.next = odd.next;
        } else {
            head = odd.next;
        }
        return head;
    }
}
