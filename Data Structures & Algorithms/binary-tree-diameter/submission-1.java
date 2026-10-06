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

    int res = -1;

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return 0;
        }

        int l = height(root.left);
        int r = height(root.right);

        int temp = l + r;

        res = Math.max(res,temp);

        diameterOfBinaryTree(root.left);
        diameterOfBinaryTree(root.right);

        return res;
    }

    private int height(TreeNode root){
        if(root == null){
            return 0;
        }

        return 1 + Math.max(height(root.left),height(root.right));
    }
}
