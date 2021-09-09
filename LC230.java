public class LC230 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static int count;
    static int res;

    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        inorder(root, k);
        return res;
    }

    public static void inorder(TreeNode root, int k) {
        if (root.left != null)
            inorder(root.left, k);
        count++;
        if (count == k)
            res = root.val;
        if (root.right != null)
            inorder(root.right, k);
    }
}
