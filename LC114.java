public class LC114 {
    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static TreeNode last;

    public void flatten(TreeNode root) {
        if (root == null)
            return;
        if (root.left != null) {
            last = root.left;
            flatten(root.left);
        }
        if (root.right != null) {
            last.right = root.right;
            last = root.right;
            flatten(root.right);
        }
        if (root.left != null) {
            root.right = root.left;
        }
        root.left = null;
    }
}
