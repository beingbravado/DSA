public class LL153 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode middleNode(ListNode head) {
        int count = 1;
        ListNode x = head;
        while (x != null) {
            count++;
            x = x.next;
        }
        count = (count + 1) / 2;
        ListNode ans = head;
        while (--count > 0) {
            ans = ans.next;
        }
        return ans;
    }
}
