public class BT195 {
    static int x=0;
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
//        System.out.println(sum(root));
        sumTree(root);
    }

    public static void sumTree(node root){
        x=0;
        sum(root.left); sum(root.right);
        root.data= x;
        System.out.println(root.data);

        if (root.left!=null) sumTree(root.left);
        if (root.right!=null)sumTree(root.right);
    }

    public static int sum(node root){
        if (root==null) return 0;

        sum(root.left);
        x+= root.data;
        sum(root.right);
        return x;
    }
}
