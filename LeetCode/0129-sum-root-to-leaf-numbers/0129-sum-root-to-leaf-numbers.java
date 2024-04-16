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
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> sq = new LinkedList<>();
        q.offer(root);
        sq.offer(root.val);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            int num = sq.poll();

            if (node.left == null && node.right == null) {
                sum += num;
            }

            if (node.left != null) {
                q.offer(node.left);
                sq.offer(num * 10 + node.left.val);
            }

            if (node.right != null) {
                q.offer(node.right);
                sq.offer(num * 10 + node.right.val);
            }
        }

        return sum;
    }
}
