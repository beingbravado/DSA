import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class LC543 {

    public class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class pair {
        int x, y;

        pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static HashMap<TreeNode, pair> hm;

    public static int diameterOfBinaryTree(TreeNode root) {
        int diameter = 0;
        hm = new HashMap<>();
        checkHeight(root);
        Iterator it = hm.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry node = (Map.Entry) it.next();
            pair p= (LC543.pair) node.getValue();
            diameter = Math.max(diameter, p.x+p.y);
        }
        return diameter;
    }

    public static int checkHeight(TreeNode root) {
        if (root == null)
            return 0;
        hm.put(root, new pair(checkHeight(root.left), checkHeight(root.right)));
        return 1 + Math.max(hm.get(root).x ,hm.get(root).y);
    }
}
