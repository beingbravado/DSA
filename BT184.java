import java.util.Stack;

public class BT184 {

    public static void recursivePostorder(node root){
        if (root==null) return;

        recursivePostorder(root.left);
        recursivePostorder(root.right);
        System.out.print(root.data+" ");
    }

    public static void iterative(node root){
        Stack<node> s= new Stack<>();
        Stack<Integer> out= new Stack<>();
        s.push(root);

        while (!s.empty()){
            node x= s.pop();

            if (x.left!= null) s.push(x.left);
            if (x.right!=null) s.push(x.right);
            out.push(x.data);
        }

        while (!out.empty()){
            System.out.print(out.pop()+" ");
        }
    }

    public static void main(String args[]){
        node root = new node(1);
        root.left = new node(2);
        root.right = new node(3);
        root.left.left = new node(4);
        root.right.left = new node(5);
        root.right.right = new node(6);
        root.right.left.left = new node(7);
        root.right.left.right = new node(8);

        recursivePostorder(root);
        System.out.println();
        iterative(root);
    }
}
