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

    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        solve(root);

        return res;
    }

    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        res = res ? Math.abs(l-r) <= 1 : false;

        return 1 + Math.max(l,r);
    }
}
