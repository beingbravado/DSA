import java.util.PriorityQueue;
import java.util.Queue;

public class LL166 {
    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    Node flatten(Node root) {
        // Your code here
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.data < b.data ? -1 : 1);
        Node ptr = root;
        while (ptr != null) {
            // System.out.println(ptr.data);
            pq.add(ptr);
            ptr = ptr.next;
        }
        Node head = new Node(-1);
        ptr = head;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            ptr.bottom = temp;
            ptr = ptr.bottom;
            if (temp.bottom != null)
                pq.add(temp.bottom);
        }
        return head.bottom;
    }
}
