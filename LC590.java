// import java.util.ArrayList;
import java.util.List;

public class LC590 {
    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    static List<Integer> list;

    public List<Integer> postorder(Node root) {
        // list = new ArrayList();
        po(root);
        return list;
    }

    public static void po(Node root) {
        if (root == null)
            return;
        for (Node node : root.children) {
            po(node);
        }
        list.add(root.val);
    }
}