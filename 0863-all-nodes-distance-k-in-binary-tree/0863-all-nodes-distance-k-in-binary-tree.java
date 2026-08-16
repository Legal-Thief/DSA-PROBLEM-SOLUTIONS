/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null)
            return ans;
        Map<TreeNode, TreeNode> hm = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            if (node.left != null) {
                q.offer(node.left);
                hm.put(node.left, node);
            }
            if (node.right != null) {
                q.offer(node.right);
                hm.put(node.right, node);
            }
        }

        Set<TreeNode> visited = new HashSet<>();
        q.offer(target);
        visited.add(target);
        int distance = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            if (distance == k) {
                while (!q.isEmpty()) {
                    ans.add(q.poll().val);
                }
                return ans;
            }
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (node.left != null && !visited.contains(node.left)) {
                    q.offer(node.left);
                    visited.add(node.left);
                }
                if (node.right != null && !visited.contains(node.right)) {
                    q.offer(node.right);
                    visited.add(node.right);
                }
                if(hm.containsKey(node) && !visited.contains(hm.get(node))){
                    q.offer(hm.get(node));
                    visited.add(hm.get(node));
                }
            }
            distance++;
        }
        return ans;
    }
}