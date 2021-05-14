import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

class node{
    int data;
    node left, right;

    public node(int item){
        data= item;
        left= right= null;
    }
}

public class BT177 {
    node root;

//    int height(node root){
//        if (root== null) return 0;
//        else {
//            int lh= height(root.left);
//            int rh= height(root.right);
//
//            if (lh>rh) return lh+1;
//            return rh+1;
//        }
//    }
//
//    void printGivenLevel (node root, int level){
//        if (root== null) return;
//
//        if (level==1) System.out.printf(root.data+" ");
//        else if (level>1) {
//            printGivenLevel(root.left, level-1);
//            printGivenLevel(root.right, level-1);
//        }
//    }

    void printLevelOrder(){
        Queue<node> q= new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            node x= q.poll();
            System.out.printf(x.data +" ");

            if (x.left!= null) q.add(x.left);
            if (x.right!=null) q.add(x.right);
        }
    }

    void reverseLevelOrder(node root){
        Stack<node> s= new Stack<>();
        Queue<node> q= new LinkedList<>();

        q.add(root);

        while (!q.isEmpty()){
            root= q.peek();
            q.remove();
            s.push(root);

            if (root.left!= null) q.add(root.left);
            if (root.right!=null) q.add(root.right);
        }

        while (!s.empty()){
            System.out.printf(s.pop().data+" ");
        }
    }

    public static void main( String args[]){
        BT177 tree= new BT177();
        tree.root= new node(1);
        tree.root.left= new node(2);
        tree.root.right= new node(3);
        tree.root.left.left= new node(4);
        tree.root.left.right= new node(5);
        tree.root.right.left= new node(6);
        tree.root.right.right= new node(7);

        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder();

        System.out.println("Reverse Level order traversal of binary tree is ");
        tree.reverseLevelOrder(tree.root);

    }
}
