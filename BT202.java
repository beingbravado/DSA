public class BT202 {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }
    }

    static int[] ans;
    static int finalLevel;

    public int sumOfLongRootToLeafPath(Node root) {
        // code here
        ans = new int[10002];
        finalLevel = 0;
        bloodline(root, 0, root.data);
        return ans[finalLevel];
    }

    public static void bloodline(Node node, int level, int sum) {
        if (node.left == null && node.right == null) {
            finalLevel = Math.max(finalLevel, level);
            ans[level] = Math.max(ans[level], sum);
            return;
        }

        if (node.left != null)
            bloodline(node.left, level + 1, sum + node.left.data);
        if (node.right != null)
            bloodline(node.right, level + 1, sum + node.right.data);
    }
}
