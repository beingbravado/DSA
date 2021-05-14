import java.util.LinkedList;
import java.util.Queue;

public class BT199 {
    public static boolean check(node root){
        int n=0, count =0;
        Queue<node> q= new LinkedList<>();
        q.add(root);
        q.add(null);

        boolean ans= true;
        while (!q.isEmpty()){
            node x= q.poll();
            if (x==null){
                if (count%n != 0){
                    ans= false;
                    break;
                }
                n=0; count=0;
                if (!q.isEmpty()) q.add(null);
                continue;
            }
            n++;
            if (x.left == null && x.right== null) count++;

            if (x.left!=null) q.add(x.left);
            if (x.right!=null) q.add(x.right);
        }

        return ans;
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
        if (check(root)) System.out.println("YES");
        else System.out.println("NO");
    }
}
