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
    class Pair{
        int p;
        TreeNode node;
        Pair(int p, TreeNode node){
            this.p= p;
            this.node= node;
        }
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root==null) return ans;
        HashMap<Integer, Integer> hm = new HashMap<>();
        Queue<Pair> q =new LinkedList<>();
        q.offer(new Pair(0,root));
        int maxHD= 0;
        while(!q.isEmpty()){
            Pair pair = q.poll();
            int tempP= pair.p;
            TreeNode tempNode = pair.node;

            hm.put(tempP,tempNode.val);
            maxHD= Math.max(maxHD, tempP);
            if(tempNode.left!=null) q.offer(new Pair(tempP+1, tempNode.left));
            if(tempNode.right!=null) q.offer(new Pair(tempP+1, tempNode.right));
        }


        for(int i=0;i<=maxHD;i++){
            ans.add(hm.get(i));
        }
        return ans;
    }
}