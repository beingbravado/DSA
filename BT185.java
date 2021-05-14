import java.util.LinkedList;
import java.util.Queue;

public class BT185 {
    static int maxlevel=0;

    public static void leftview(node root, int level){
        if (root==null) return;

        if (maxlevel<level){
            System.out.print(" "+root.data);
            maxlevel=level;
        }

        leftview(root.left,level+1);
        leftview(root.right,level+1);
    }

    public static void newtechnique(node root){
        Queue<node> p= new LinkedList<>();
        Queue<node> q= new LinkedList<>();
        Queue<node> ans= new LinkedList<>();
        q.add(root);
        char c='p';
        while (!p.isEmpty() || !q.isEmpty()){
            if (c == 'p') {
                node x= p.poll();

                if (x.left!= null) q.add(x.left);
                if (x.right!=null) q.add(x.right);

                if (p.isEmpty()) {
                    c='q';
                    System.out.println(q.peek());
                }
            } else {
                node x= q.poll();

                if (x.left!= null) p.add(x.left);
                if (x.right!=null) p.add(x.right);

                if (q.isEmpty()) {
                    c='p';
                    System.out.println(p.peek());
                }
            }
            node x= q.poll();
            System.out.printf(x.data +" ");

            if (x.left!= null) q.add(x.left);
            if (x.right!=null) q.add(x.right);
        }
    }

    public static void main(String args[]){
        node root = new node(10);
        root.left = new node(20);
        root.right = new node(30);
        root.left.left = new node(40);
        root.right.left = new node(5);
        root.right.right = new node(6);
        root.right.left.left = new node(7);
        root.right.left.right = new node(8);

        leftview(root,1);
        newtechnique(root);
    }
}
