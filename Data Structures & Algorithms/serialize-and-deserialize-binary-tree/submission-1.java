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

public class Codec {

    int preOrderIndex = 0;

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serializeHelper(root, sb);
        return sb.toString();
    }

    private void serializeHelper(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#,");
            return;
        }

        sb.append(root.val).append(",");

        serializeHelper(root.left, sb);
        serializeHelper(root.right, sb);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");

        return deserializeHelper(values);
    }

    private TreeNode deserializeHelper(String[] values) {

        if (values[preOrderIndex].equals("#")) {
            preOrderIndex++;
            return null;
        }

        TreeNode root =
            new TreeNode(Integer.parseInt(values[preOrderIndex]));

        preOrderIndex++;

        root.left = deserializeHelper(values);
        root.right = deserializeHelper(values);

        return root;
    }
}