import java.util.PriorityQueue;
import java.util.Queue;

public class LL169 {
    static class Node {
        int data;
        Node next;

        Node(int key) {
            data = key;
            next = null;
        }
    }

    Node mergeKList(Node[] arr, int K) {
        // Add your code here.
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.data > b.data ? 1 : -1);
        for (int i = 0; i < arr.length; i++)
            pq.add(arr[i]);

        Node head = pq.poll();
        if (head.next != null)
            pq.add(head.next);
        Node ptr = head;
        while (!pq.isEmpty()) {
            Node temp = pq.poll();
            ptr.next = temp;
            ptr = ptr.next;
            if (temp.next != null)
                pq.add(temp.next);
        }

        return head;
    }
}
