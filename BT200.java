import java.util.ArrayList;
import java.util.HashSet;

public class BT200 {
    static ArrayList<Integer> list= new ArrayList<>();
    static HashSet<ArrayList> set= new HashSet<>();
    static boolean flag= false;


    public static boolean isDuplicate(node root){
        list.clear();
        inorder(root);
        if (list.size()>1){
            int x= set.size();
            set.add(list);
            System.out.println(list);
            if (set.size()==x){
                flag= true;
                return flag;
            }
        }

        if (root.left!=null) isDuplicate(root.left);
        if (root.right!=null) isDuplicate(root.right);
        return flag;
    }

    public static void inorder(node root){
        if (root.left!=null) inorder(root.left);
        list.add(root.data);
        if (root.right!=null) inorder(root.right);
    }

    public static void main(String args[]){
        node root = new node(10);
        root.right = new node(30);
        root.left = new node(20);
        root.left.left = new node(40);
        root.left.right = new node(50);
//        root.right.left = new node(5);

        root.right.right = new node(20);
        root.right.right.left = new node(40);
        root.right.right.right = new node(50);
//        root.right.right = new node(6);
//        root.right.left.left = new node(7);
//        root.right.left.right = new node(8);
//        root.right.left.right.right = new node(81);
//        root.right.left.right.right.right = new node(82);

        set.clear();
        boolean ans=isDuplicate(root);
        if (ans) System.out.println("True");
        else System.out.println("False");
    }
}
