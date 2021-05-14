import java.util.*;

public class BT192 {

    static ArrayList<Integer> ans= new ArrayList<>();
    static HashSet<node> set = new HashSet<>();

    public static ArrayList<Integer> boundryTraversal(node root){
        Stack<node> s= new Stack<>();
        ans.add(root.data);
        set.add(root);

        node x= root;
        while (true){
            if (x.left!= null) x= x.left;
            else if (x.right!= null) x= x.right;
            else break;

            if (!set.contains(x)) {
                set.add(x);
                ans.add(x.data);
            }
        }

        leafs(root);

        node z= root;
        while (true){
            if (z.right != null) z= z.right;
            else if (z.left!= null) z= z.left;
            else break;

            if (!set.contains(z)) {
                set.add(z);
                s.add(z);
            }
        }

        while (!s.isEmpty()) ans.add(s.pop().data);

        return ans;
    }

    public static void leafs(node root){
        if (root== null) return;

        leafs(root.left);
        leafs(root.right);
        if (root.left == null && root.right== null) {
            if (!set.contains(root)) {
                set.add(root);
                ans.add(root.data);
            }
        }
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

        ArrayList<Integer> ans= boundryTraversal(root);
        for (int x: ans) System.out.print(x+" ");
    }
}
