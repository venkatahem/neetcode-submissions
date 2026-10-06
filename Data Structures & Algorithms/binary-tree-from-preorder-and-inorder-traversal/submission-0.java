/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[0]);

        int pivot = 0;
        while (inorder[pivot] != preorder[0]) {
            pivot++;
        }

        root.left = buildTree(
            Arrays.copyOfRange(preorder, 1, pivot + 1), Arrays.copyOfRange(inorder, 0, pivot));
        root.right = buildTree(Arrays.copyOfRange(preorder, pivot + 1, preorder.length),
            Arrays.copyOfRange(inorder, pivot + 1, inorder.length));

        return root;
    }
}
