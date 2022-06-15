class Solution {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean answer;
        
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            if (p.val != q.val) {
                return false;
            } else {
                answer = isSameTree(p.left, q.left);
                if (answer) {
                    answer = isSameTree(p.right, q.right);
                }
            }
        }
        return answer;
    }
}