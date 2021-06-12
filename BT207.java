public class BT207 {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
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
}
