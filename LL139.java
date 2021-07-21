public class LL139 {
    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    Node reverseListIterative(Node head) {
        // code here
        Node prev = head, curr = head.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            head = prev;
        }
        return head;
    }

    Node reverseList(Node head) {
        // code here
        if (head == null || head.next == null)
            return head;
        Node nextNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return nextNode;
    }
}
