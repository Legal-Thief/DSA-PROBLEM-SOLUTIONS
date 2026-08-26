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
    int preIndex= 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map =new HashMap<>();
        int n= inorder.length;
        for(int i=0;i<n;i++){
            map.put(inorder[i],i);
        }
        return build(preorder, map , 0, n-1);
    }
    public TreeNode build(int[] preorder, HashMap<Integer,Integer> map, int start, int end){
        if(start>end){
            return null;
        }
        
        int rootVal= preorder[preIndex++];

        TreeNode root =new TreeNode(rootVal);
        int ind= map.get(rootVal);
        
        root.left= build(preorder, map , start, ind-1);
        root.right= build(preorder, map , ind+1, end);
        return root;


    }
}