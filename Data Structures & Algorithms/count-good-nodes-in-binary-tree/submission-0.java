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
    int sol = 0;
    public int goodNodes(TreeNode root) {
        solve(root, root.val);

        return sol;
    }

    private void solve(TreeNode root, int prevLargeValue) {
        if (root == null) {
            return;
        }

        int currLarge = prevLargeValue;

        if (root.val >= prevLargeValue) {
            sol++;
            currLarge = root.val;
        }

        solve(root.left, currLarge);
        solve(root.right, currLarge);
    }
}
