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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm = new TreeMap<>();
        helper(tm, root, 0, 0);

        for (TreeMap<Integer, PriorityQueue<Integer>> outer : tm.values()) {
            List<Integer> al = new ArrayList<>();
            for (PriorityQueue<Integer> inner : outer.values()) {
                while (!inner.isEmpty()) {
                    al.add(inner.poll());
                }
            }
            ans.add(al);
        }
        return ans;

    }

    public void helper(TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> tm, TreeNode root, int col, int row) {
        if (root == null)
            return;
        tm.putIfAbsent(col, new TreeMap<>());
        tm.get(col).putIfAbsent(row, new PriorityQueue<>());
        tm.get(col).get(row).add(root.val);
        helper(tm, root.left, col - 1, row + 1);
        helper(tm, root.right, col + 1, row + 1);
    }
}