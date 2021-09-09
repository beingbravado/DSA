public class LC105 {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        TreeNode root = build(preorder, inorder, 0, n, 0, n);
        return root;
    }

    public static TreeNode build(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
        if (preEnd <= preStart && inEnd <= inStart)
            return null;

        TreeNode root = new TreeNode(pre[preStart]);
        int count = 0;
        for (int i = inStart; i < inEnd; i++) {
            if (in[i] != pre[preStart])
                count++;
            else
                break;
        }

        root.left = build(pre, in, preStart + 1, preStart + count + 1, inStart, inStart + count);
        root.right = build(pre, in, preStart + count + 1, preEnd, inStart + count + 1, inEnd);

        return root;
    }
}
