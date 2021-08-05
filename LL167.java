public class LL167 {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    static Node segregate(Node head) {
        // add your code here
        int[] count = new int[3];
        Node x = head;
        while (x != null) {
            count[x.data]++;
            x = x.next;
        }

        int index = 0;
        x = head;
        while (x != null && index < 3) {
            if (count[index] == 0)
                index++;
            else {
                x.data = index;
                count[index]--;
                x = x.next;
            }
        }
        return head;
    }
}
