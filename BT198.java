public class BT198 {
    static int x=0;
    static boolean flag= true;
    public static int sum(node root)
    {
        // Your code here
        if (root== null) return 0;
//        if (root.left== null && root.right==null) return root.data;

        sum(root.left);
        x+= root.data;
        sum(root.right);

        return x;
    }
    public static void sumTree(node root){
        x=0;
        if (root.left!=null && root.right!=null) {
            sum(root.left);
            sum(root.right);
        } else x= root.data;
        if (root.data!=x) flag= false;

        if (root.left!=null) sumTree(root.left);
        if (root.right!=null) sumTree(root.right);
    }

    public static boolean isSumTree(node root){
        flag= true;
        sumTree(root);
        return flag;
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
//        System.out.println(sum(root));
        boolean ans=isSumTree(root);
        if (ans) System.out.println("True");
        else System.out.println("False");
    }
}
