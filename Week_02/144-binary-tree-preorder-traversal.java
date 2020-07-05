/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        // 迭代算法
        if (root == null) {
            return Collections.emptyList();
        }
        TreeNode currentNode = root;
        List<Integer> retList = new ArrayList<>();
        // stack 栈中节点放入顺序为：中，弹出；右，左
        Stack<TreeNode> stack = new Stack<>();
        stack.push(currentNode);
        while (!stack.isEmpty()) {
            currentNode = stack.pop();
            retList.add(currentNode.val);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
        return retList;
    }
}