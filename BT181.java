public class BT181 {
    static class node{
        int value;
        node left, right;
    }

    static node createNode(int val){
        node newNode= new node();
        newNode.value= val;
        newNode.left= newNode.right= null;
        return newNode;
    }

    static void inorder(node root){
        if (root== null) return;

        inorder(root.left);
        System.out.print(root.value);
        inorder(root.right);
    }

    static node mirrorify(node root){
        if (root==null) return null;

        node mirror= createNode(root.value);
        mirror.left= mirrorify(root.right);
        mirror.right= mirrorify(root.left);

        return mirror;
    }

    public static void main(String args[])
    {

        node tree = createNode(5);
        tree.left = createNode(3);
        tree.right = createNode(6);
        tree.left.left = createNode(2);
        tree.left.right = createNode(4);

        System.out.print("Inorder of original tree: ");
        inorder(tree);
        node mirror = null;
        mirror = mirrorify(tree);

        System.out.print("\nInorder of mirror tree: ");
        inorder(mirror);
    }
}
