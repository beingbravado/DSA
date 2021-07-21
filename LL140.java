public class LL140 {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    public static Node reverse(Node node, int k) {
        // Your code here
        if (k <= 1)
            return node;
        Node pre = new Node(0);
        pre.next = node;
        Node head = pre;
        Node curr = node, last = node.next;
        int count = 0;
        while (last != null) {
            while (++count < k && last != null) {
                curr.next = last.next;
                last.next = pre.next;
                pre.next = last;

                last = curr.next;
            }
            if (curr.next == null)
                break;
            pre = curr;
            curr = last;
            last = last.next;
            count = 0;
        }
        return head.next;
    }
}
