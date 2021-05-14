import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BT186 {

    public static void rightview(node root){

    }

    public static void rightviewQ(node root){
        Queue<node> q= new LinkedList<>();
        q.add(root);
        q.add(null);
        ArrayList<Integer> ans= new ArrayList<>();

        node x= root;
        while (!q.isEmpty()){
            node y= q.poll();
            if (y==null){
                ans.add(x.data);
                if (q.isEmpty()) break;
                else q.add(null);
            } else {
                x=y;
                if (x.left!=null){
                    q.add(x.left);
                }
                if (x.right!=null){
                    q.add(x.right);
                }
            }
        }

        for (int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
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

        rightview(root);
        System.out.println();
        rightviewQ(root);
    }
}
