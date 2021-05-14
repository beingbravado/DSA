public class BT194 {
    static node head;
    static node prev;
    public static node bToDLL(node root)
    {
        bt2dll(root);
        return root;
    }

    public static void bt2dll(node root)
    {
        //  Your code here
        if (root== null) return;
        bToDLL(root.left);

        if (head==null){
            head= root;
            prev= root;
        } else {
            root.left= prev;
            prev.right= root;
            prev= root;
        }

        bToDLL(root.right);
    }

    public static void main(String args[]){
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

//        ArrayList<Integer> ans= boundryTraversal(root);
//        for (int x: ans) System.out.print(x+" ");
    }
}
