public class LC124 {
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

    static int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        path(root);
        return maxPath;
    }

    public static int path(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = path(root.left);
        int rightSum = path(root.right);
        int x = Math.max(root.val, root.val + Math.max(leftSum, rightSum));
        maxPath = Math.max(maxPath, Math.max(x, root.val + leftSum + rightSum));
        return x;
    }
}
