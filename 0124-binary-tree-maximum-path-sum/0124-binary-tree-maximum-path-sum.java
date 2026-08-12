class Solution {

    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {

        helper(root);

        return max;
    }


    public int helper(TreeNode root) {

        if(root == null)
            return 0;


        int left = Math.max(0, helper(root.left));

        int right = Math.max(0, helper(root.right));


       
        int curr = root.val + left + right;


        max = Math.max(max, curr);


       
        return root.val + Math.max(left, right);
    }
}