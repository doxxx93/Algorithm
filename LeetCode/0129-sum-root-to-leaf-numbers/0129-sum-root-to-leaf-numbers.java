/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Stack<TreeNode> q = new Stack<>();
        Stack<Integer> sq = new Stack<>();
        q.push(root);
        sq.push(root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int num = sq.poll();

            if (node.left == null && node.right == null) {
                sum += num;
            }

            if (node.left != null) {
                q.push(node.left);
                sq.push(num * 10 + node.left.val);
            }

            if (node.right != null) {
                q.push(node.right);
                sq.push(num * 10 + node.right.val);
            }
        }

        return sum;
    }
}
