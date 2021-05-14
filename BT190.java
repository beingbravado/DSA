public class BT190 {
    static class node {
        node left, right;
        int data;

        node(int item) {
            data = item;
        }
    }

    public static boolean isBalanced(node root) {
        if (root == null)
            return true;

        int lh = height(root.left);
        int rh = height(root.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        return false;
    }

    public static int height(node root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        if (lh > rh)
            return lh + 1;
        return rh + 1;
    }

    public static void main(String args[]) {
        node root = new node(10);
        root.left = new node(20);
        root.right = new node(30);
        root.left.left = new node(40);
        root.left.right = new node(4);
        root.right.left = new node(5);
        root.right.right = new node(6);
        root.right.left.left = new node(7);
        root.right.left.right = new node(8);
        root.right.left.right.right = new node(81);
        root.right.left.right.right.right = new node(82);

        if (isBalanced(root))
            System.out.println("true");
        else
            System.out.println("false");

    }
}
