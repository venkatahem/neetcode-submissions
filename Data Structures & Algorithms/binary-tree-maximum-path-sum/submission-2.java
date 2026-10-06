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

    /*
    three conditions
    1. whether the child part needs to be considered ?
    2. whether the current nodes make the path ?
    3. whether only the current node needs to be consider for next stage ?
    */

    int sol = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        solve(root);

        return sol;
    }

    private int solve(TreeNode root){
        if(root == null){
            return 0;
        }

        int l = solve(root.left);
        int r = solve(root.right);

        int temp = Math.max(root.val,root.val+Math.max(l,r));
        int temp1 = Math.max(temp,root.val+l+r);
        sol = Math.max(temp1,sol);

        return temp;
    }
}
