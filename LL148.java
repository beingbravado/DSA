public class LL148 {
    static class Node {
        int data;
        Node next;

        Node(int x) {
            data = x;
            next = null;
        }
    }

    static Node addTwoLists(Node first, Node second) {
        // code here
        // return head of sum list
        Node sum = new Node(0);
        Node ans = sum;
        Node revFirst = reverse(first);
        Node revSecond = reverse(second);

        int carry = 0;
        while (revFirst != null && revSecond != null) {
            Node x = new Node(revFirst.data + revSecond.data + carry);
            carry = 0;
            if (x.data >= 10) {
                x.data = x.data % 10;
                carry = 1;
            }
            sum.next = x;
            sum = sum.next;
            revFirst = revFirst.next;
            revSecond = revSecond.next;
        }
        while (revFirst != null) {
            Node x = new Node(revFirst.data + carry);
            carry = 0;
            if (x.data >= 10) {
                x.data = x.data % 10;
                carry = 1;
            }
            sum.next = x;
            sum = sum.next;
            revFirst = revFirst.next;
        }
        while (revSecond != null) {
            Node x = new Node(revSecond.data + carry);
            carry = 0;
            if (x.data >= 10) {
                x.data = x.data % 10;
                carry = 1;
            }
            sum.next = x;
            sum = sum.next;
            revSecond = revSecond.next;
        }
        if (carry > 0) {
            Node x = new Node(carry);
            sum.next = x;
            sum = sum.next;
        }
        return reverse(ans.next);
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
