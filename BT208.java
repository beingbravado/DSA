public class BT208 {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    static int lca, x, y;

    int findDist(Node root, int a, int b) {
        // Your code here
        if (root == null)
            return 0;
        x = -1;
        y = -1;
        Node base = lca(root, a, b);
        findDist(root, base, a, b, 0);
        return (x - lca) + (y - lca);
    }

    public static Node lca(Node node, int n1, int n2) {
        if (node == null)
            return null;
        if (node.data == n1 || node.data == n2) {
            return node;
        }
        Node left = lca(node.left, n1, n2);
        Node right = lca(node.right, n1, n2);

        if (left != null && right != null)
            return node;

        return left != null ? left : right;
    }

    public static void findDist(Node root, Node base, int a, int b, int level) {
        if (root == null)
            return;
        if (root == base)
            lca = level;
        if (root.data == a)
            x = level;
        if (root.data == b)
            y = level;
        if (x >= 0 && y >= 0)
            return;
        findDist(root.left, base, a, b, level + 1);
        findDist(root.right, base, a, b, level + 1);
    }
}
