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
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }
        List<Integer> retList = new ArrayList<>(inorderTraversal(root.left));
        retList.add(root.val);
        retList.addAll(inorderTraversal(root.right));
        return retList;
    }
}