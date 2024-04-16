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
public class Solution {
    List<List<Integer>> pathArr = new ArrayList<>();

    public boolean hasPathSum(TreeNode root, int targetSum) {
        rootToLeaf(root, new ArrayList<>());

        for (List<Integer> path : pathArr) {
            int sum = 0;
            for (int val : path) {
                sum += val;
            }
            if (sum == targetSum) {
                return true;
            }
        }

        return false;
    }

    private void rootToLeaf(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        arr.add(root.val);

        if (root.left == null && root.right == null) {
            pathArr.add(new ArrayList<>(arr));
        } else {
            rootToLeaf(root.left, new ArrayList<>(arr));
            rootToLeaf(root.right, new ArrayList<>(arr));
        }
    }
}