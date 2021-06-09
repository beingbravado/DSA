// import java.util.*;

// public class Graph364 {
//     class Node {
//         public int val;
//         public List<Node> neighbors;

//         public Node() {
//             val = 0;
//             neighbors = new ArrayList<Node>();
//         }

//         public Node(int _val) {
//             val = _val;
//             neighbors = new ArrayList<Node>();
//         }

//         public Node(int _val, ArrayList<Node> _neighbors) {
//             val = _val;
//             neighbors = _neighbors;
//         }
//     }

//     public static Node cloneGraph(Node node) {
//         if (node == null)
//             return null;
//         // Node copy = new Node(node.val);
//         Node[] visited = new Node[101];
//         clone(node, copy, visited);
//         return copy;
//     }

//     public static void clone(Node node, Node copy, Node[] visited) {
//         visited[copy.val] = copy;

//         // ArrayList<Node> nbr= node.neighbors;
//         for (Node xnode : node.neighbors) {
//             if (visited[xnode.val] == null) {
//                 // Node newnode = new Node(xnode.val);
//                 copy.neighbors.add(newnode);
//                 clone(xnode, newnode, visited);
//             } else {
//                 copy.neighbors.add(visited[xnode.val]);
//             }
//         }
//     }
// }
