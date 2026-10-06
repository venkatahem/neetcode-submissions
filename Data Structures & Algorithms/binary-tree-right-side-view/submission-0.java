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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<TreeNode> que = new ArrayDeque<>();
        List<Integer> sol = new ArrayList<>();

        que.offer(root);

        while (!que.isEmpty()) {
            TreeNode curr;
            int size = que.size();

            for (int i = 0; i < size; i++) {
                curr = que.poll();
                if (curr.left != null) {
                    que.offer(curr.left);
                }
                if (curr.right != null) {
                    que.offer(curr.right);
                }
                if (i != size - 1) {
                    continue;
                }

                sol.add(curr.val);
            }
        }

        return sol;
    }
}
