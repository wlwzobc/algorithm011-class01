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
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> retList = new ArrayList<>();
        List<Node> nodeList = Collections.singletonList(root);
        while (!nodeList.isEmpty()) {
            List<Integer> tempList = new ArrayList<>();
            List<Node> tempNodes = new ArrayList<>();
            for (Node child : nodeList) {
                tempList.add(child.val);
                if (child.children != null && !child.children.isEmpty()) {
                    tempNodes.addAll(child.children);
                }
            }
            retList.add(tempList);
            nodeList = tempNodes;
        }
        return retList;
    }

}