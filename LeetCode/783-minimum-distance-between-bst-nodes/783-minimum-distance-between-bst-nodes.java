class Solution {
    private int min = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int minDiffInBST(TreeNode root) {
        dfs(root);
        return min;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (prev != null) {
            int diff = Math.abs(root.val - prev.val);
            min = Math.min(min, diff);
        }
        prev = root;
        dfs(root.right);
    }
}