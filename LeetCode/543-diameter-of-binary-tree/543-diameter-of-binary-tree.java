public class Solution {

    int diameter;

    public int diameterOfBinaryTree(TreeNode root) {
        diameter = 0;
        dfs(root);

        return diameter;

    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);

        diameter = Math.max(diameter, left + right);
        return 1 + Math.max(left, right);
    }
}