import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BT189 {

    public static void zigzag(node root){
        Stack<node> s= new Stack<>();
        Queue<node> q= new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();

        q.add(root);
        q.add(null);
        int level=0;

        while (!q.isEmpty()){
            node x= q.poll();
            if (x==null){
                level++;
                while (!s.isEmpty()) ans.add(s.pop().data);

                if (q.isEmpty()) break;
                else continue;
            }

            if (x.left!=null) q.add(x.left);
            if (x.right!=null) q.add(x.right);

            if (level%2==1) s.add(x);
            else ans.add(x.data);
        }

        for (int x: ans) System.out.print(x +" ");
        System.out.println();
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

        zigzag(root);

    }
}
