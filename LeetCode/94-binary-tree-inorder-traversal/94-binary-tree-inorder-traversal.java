class Solution {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> answer = new ArrayList<>();
        return addInorder(root, answer);
    }

    private List<Integer> addInorder(TreeNode root, List<Integer> answer) {
        if (root == null) {
            return answer;
        }
        addInorder(root.left, answer);
        answer.add(root.val);
        addInorder(root.right, answer);
        return answer;
    }
}