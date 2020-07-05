/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> retList = new ArrayList<>();
        retList.add(root.val);
        if (root.children != null && !root.children.isEmpty()) {
            for (Node child : root.children) {
                retList.addAll(preorder(child));
            }
        }
        return retList;
    }
}