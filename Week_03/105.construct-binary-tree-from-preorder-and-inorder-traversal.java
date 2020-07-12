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
    Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int length = inorder.length;
        for (int i = 0; i < length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeNode(preorder, 0, length - 1, inorder, 0, length - 1);
    }
    private TreeNode buildTreeNode(int[] preorder, int preorderLeft, 
            int preorderRight, int[] inorder, int inorderLeft, int inorderRight){
        if (preorderLeft > preorderRight) {
            return null;
        }
        int rootVal = preorder[preorderLeft];
        int inorderRootIdx = map.get(rootVal);
        int leftNums = inorderRootIdx - inorderLeft;
        TreeNode rootNode = new TreeNode(rootVal);
        rootNode.left = buildTreeNode(preorder, preorderLeft + 1, preorderLeft + leftNums, inorder, inorderLeft, inorderRootIdx - 1);
        rootNode.right = buildTreeNode(preorder, preorderLeft + leftNums + 1, preorderRight, inorder, inorderRootIdx + 1, inorderRight);
        return rootNode;
    }
}