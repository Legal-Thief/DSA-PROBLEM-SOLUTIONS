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
    class Pair {
        int ind;
        TreeNode node;

        Pair(int ind, TreeNode node) {
            this.ind = ind;
            this.node = node;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0, root));
        while (!q.isEmpty()) {
            int size = q.size();
            int first = 0;
            int last = 0;

            for (int i = 0; i < size; i++) {
                Pair temp = q.poll();

                if (i == 0)
                    first = temp.ind;
                if (i == size - 1)
                    last = temp.ind;

                TreeNode node = temp.node;

                if (node.left != null)
                    q.offer(new Pair(2 * temp.ind + 1, node.left));

                if (node.right != null)
                    q.offer(new Pair(2 * temp.ind + 2, node.right));
            }

            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}