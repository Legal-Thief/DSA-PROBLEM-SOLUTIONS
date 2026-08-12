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
    public boolean isSymmetric(TreeNode root) {
        return helper(root.left, root.right);
    }
    public boolean helper(TreeNode rootL, TreeNode rootR){
         if(rootL == null && rootR == null)
            return true;


        if(rootL == null || rootR == null)
            return false;


        return rootL.val == rootR.val
            && helper(rootL.left, rootR.right)
            && helper(rootL.right, rootR.left);

    }
}