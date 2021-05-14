public class BT180 {
    node root;

    public int height(node root){
        if (root==null) return 0;

        int lh= height(root.left);
        int rh= height(root.right);

        if (lh>rh) return lh+1;
        return rh+1;
    }


}
