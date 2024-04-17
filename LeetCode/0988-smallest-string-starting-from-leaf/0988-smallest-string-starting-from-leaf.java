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
    public String smallestFromLeaf(TreeNode root) {
        return dfs(root, "");
    }

    private String dfs(TreeNode node, String suffix) {
        if (node == null) {
            return suffix;
        }
        suffix = (char)('a' + node.val) + suffix;
        if (node.left == null && node.right == null) {
            return suffix;
        }
        if (node.left == null) {
            return dfs(node.right, suffix);
        }
        if (node.right == null) {
            return dfs(node.left, suffix);
        }
        String left = dfs(node.left, suffix);
        String right = dfs(node.right, suffix);
        return left.compareTo(right) <= 0 ? left : right;
    }
}