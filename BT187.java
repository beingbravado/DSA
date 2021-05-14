import java.util.*;

public class BT187 {

    static class pair{
        node root;
        int level;

        pair(node x, int y){
            root= x;
            level=y;
        }
    }

    public static void topview(node root){
        HashMap<Integer, node> map= new HashMap<>();
        Queue<pair> q= new LinkedList<>();
        Stack<Integer> s= new Stack<>();
        Queue<Integer> p= new LinkedList<>();
        ArrayList<Integer> ans= new ArrayList<>();
        q.add(new pair(root,0));

        while (!q.isEmpty()){
            pair qq= q.poll();
            node x= qq.root;
            int y = qq.level;

            if (!map.containsKey(y)){
                map.put(y, x);
            }

            if (x.left!=null) q.add(new pair(x.left, y-1));
            if (x.right!=null) q.add(new pair(x.right, y+1));
        }

        for (Map.Entry<Integer, node> x :
                map.entrySet()) {
//            System.out.print(x.getValue().data + " ");
            if (x.getKey()<0) s.add(x.getValue().data);
            else p.add(x.getValue().data);
        }

        while (!s.empty()) ans.add(s.pop());
        while (!p.isEmpty()) ans.add(p.poll());

        for (int x: ans) System.out.print(x+" ");
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

        topview(root);
    }
}
