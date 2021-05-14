import java.util.Stack;

public class BT183 {
    public static void recursivePreorder(node root){
        if (root==null) return;

        System.out.print(root.data+" ");
        recursivePreorder(root.left);
        recursivePreorder(root.right);
    }

    public static void iterative(node root){
        Stack<node> s= new Stack<>();
        node x= root;

        while (!s.empty() || x!=null){
            if (x!= null){
                s.push(x);
                if (x.data!=-1){
                    System.out.print(x.data+" ");
                    x.data=-1;
                }
                x= x.left;
            } else {
                x=s.pop();
                x=x.right;
            }
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

        recursivePreorder(root);
        System.out.println();
        iterative(root);
    }
}
