public class LC1367 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static boolean ans;

    public boolean isSubPath(ListNode head, TreeNode root) {
        ListNode temp = head;
        String path = "";
        while (temp != null) {
            path += temp.val + " ";
            temp = temp.next;
        }
        System.out.println(path);
        ans = false;
        pathTravelled(root, path, "");
        return ans;
    }

    public static void pathTravelled(TreeNode root, String path, String psf) {
        if (psf.length() >= path.length()) {
            String newPath = psf.substring(psf.length() - path.length());
            if (newPath.equals(path)) {
                ans = true;
                return;
            }
        }
        if (root == null)
            return;
        pathTravelled(root.left, path, psf + root.val + " ");
        pathTravelled(root.right, path, psf + root.val + " ");
    }
}
