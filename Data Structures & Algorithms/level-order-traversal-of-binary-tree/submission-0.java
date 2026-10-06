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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Deque<TreeNode> tree = new ArrayDeque<>();
        List<List<Integer>> sol = new ArrayList<>();

        tree.offer(root);

        while(!tree.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = tree.size();

            TreeNode curr;

            for(int i=0;i<size;i++){
                curr = tree.poll();
                list.add(curr.val);
                if(curr.left != null){
                    tree.add(curr.left);
                }
                if(curr.right != null){
                    tree.add(curr.right);
                }
            }

            sol.add(list);
        }

        return sol;
    }
}
