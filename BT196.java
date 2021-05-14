import java.util.Scanner;

public class BT196 {
    static node root;
    static int index=0;

    public static node buildTree(int inorder[], int preorder[], int start, int end){
        if (start>end) return null;

        node x= new node(preorder[index++]);
        if (start==end) return x;

        int ioIndex= search( inorder, start, end, x.data);

        x.left = buildTree( inorder, preorder, start, ioIndex-1);
        x.right= buildTree( inorder, preorder, ioIndex+1, end);

        return x;
    }

    public static int search(int inorder[], int start, int end, int value){
        for (int i=start;i<=end;i++){
            if (inorder[i]==value) return i;
        }
        return 0;
    }

    public static void printInorder(node root)
    {
        if (root == null)
            return;

        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }

    public static void main(String args[]){
        Scanner scan= new Scanner(System.in);
        int n= scan.nextInt();
        int[] inorder= new int[n];
        int[] preorder= new int[n];
        for (int i=0;i<n;i++) inorder[i]= scan.nextInt();
        for (int i=0;i<n;i++) preorder[i]= scan.nextInt();

        node root= buildTree(inorder,preorder,0,n-1);
        printInorder(root);
    }
}
