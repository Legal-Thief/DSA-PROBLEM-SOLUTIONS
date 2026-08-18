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
    public List<Integer> postorderTraversal(TreeNode root) {
        Stack<TreeNode> st1= new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        List<Integer> al = new ArrayList<>();
        if(root== null) return al;
        st1.push(root);
        while(!st1.isEmpty()){
            TreeNode curr = st1.pop();
            st2.push(curr);
            if(curr.left!=null) st1.push(curr.left);
            if(curr.right !=null) st1.push(curr.right);
        }
        while(!st2.isEmpty()){
            TreeNode curr = st2.pop();
            al.add(curr.val);
        }
        return al;
    }
}