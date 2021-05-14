//public class ishika {
//    static class Node
//    {
//        Node left,right;
//        int data;
//        Node(int item)
//        {
//            data=item;
//        }
//    }
//    Node root;
//    static int f=1;
//    static int s=0;
//    static int sum(Node root)
//    {
//        if(root==null)
//            return 0;
//        sum(root.left);
//        s+=root.data;
//        sum(root.right);
//        return s;
//    }
//    static void sumTree(Node root)
//    {
//        int ls = 0,rs=0;
//        s=0;
//        if(root==null)
//            return ;
//        if(root.left!=null)
//        {
//            ls=sum(root.left);
//        }
//        s=0;
//        if(root.right!=null)
//        {
//            rs=sum(root.right);
//        }
//        System.out.println(ls+" "+rs+" "+" "+root.data);
//        if((ls+rs!=root.data)&&((root.left!=null)&&(root.right!=null)))
//        {
//            System.out.println(root.data);
//            f=0;
//        }
//        if(root.left!=null)
//            sumTree(root.left);
//        if(root.right!=null)
//            sumTree(root.right);
//    }
//    public static void main(String[] args)
//    {
//        ishika tree=new ishika();
//        tree.root=new Node(26);
//        tree.root.left=new Node(10);
//        tree.root.left.left=new Node(4);
//        tree.root.left.right=new Node(6);
////		tree.root.left.right.left=new Node(10);
////		tree.root.left.right.right=new Node(14);
//        tree.root.right=new Node(3);
//        tree.root.right.right=new Node(3);
//        sumTree(tree.root);
//        if(f==1)
//            System.out.println(1);
//        else
//            System.out.println(0);
//
//
//    }
//}
