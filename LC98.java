public class LC98 {
    class TreeNode {
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

    static class Node {
        boolean isBST;
        int max;
        int min;
    }

    public boolean isValidBST(TreeNode root) {
        Node solution = checkBST(root);
        return solution.isBST;
    }

    public static Node checkBST(TreeNode root) {
        if (root == null) {
            Node temp = new Node();
            temp.min = Integer.MAX_VALUE;
            temp.max = Integer.MIN_VALUE;
            temp.isBST = true;
            return temp;
        }

        Node left = checkBST(root.left);
        Node right = checkBST(root.right);

        Node curr = new Node();
        curr.isBST = left.isBST && right.isBST && (root.val >= left.max && root.val <= right.min);
        curr.max = Math.max(root.val, Math.max(left.max, right.max));
        curr.min = Math.min(root.val, Math.min(left.min, right.min));

        return curr;
    }
}
