import java.util.Stack;

public class BT182 {
    public static void iterative(node root){
        Stack<node> stack= new Stack<>();
        node x= root;

        while (!stack.empty() || x!=null){
            if (x!=null){
                stack.push(x);
                x= x.left;
            } else {
                x= stack.pop();
                System.out.print(x.data+" ");
                x= x.right;
            }
        }
    }

    public static void recursiveInorder(node root){
        if (root==null) return;

        recursiveInorder(root.left);
        System.out.print(root.data+" ");
        recursiveInorder(root.right);
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

        iterative(root);
        recursiveInorder(root);
    }
}
