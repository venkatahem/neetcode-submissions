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
    boolean sol = true;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        checkSubTree(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

        return sol;
    }

    private void checkSubTree(TreeNode root,int l,int r) {
        if (root == null) {
            return;
        }

        checkSubTree(root.left,l,root.val);
        checkSubTree(root.right,root.val,r);

        int val = root.val;

        if (val <= l || val >= r) {
            sol = false;
        }

    }
}
