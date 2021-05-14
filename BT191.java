import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT191 {

    public static void diagonalTraversal(node root){
        ArrayList<Integer> ans= new ArrayList<>();
        Queue<node> q= new LinkedList<>();
        node x= root;

        while (true){
            ans.add(x.data);
            if (x.left!=null) q.add(x.left);

            if (x.right!=null) x= x.right;
            else if (!q.isEmpty())x= q.poll();
            else break;
        }

        for (int i: ans) System.out.print(i+" ");
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

        diagonalTraversal(root);
        System.out.println();
    }
}
