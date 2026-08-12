class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans = new ArrayList<>();

        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm = new TreeMap<>();

        helper(root, tm, 0, 0);

        for(Map.Entry<Integer,TreeMap<Integer,PriorityQueue<Integer>>> col : tm.entrySet()){

            List<Integer> al = new ArrayList<>();

            for(Map.Entry<Integer,PriorityQueue<Integer>> row : col.getValue().entrySet()){

                PriorityQueue<Integer> q = row.getValue();

                while(!q.isEmpty()){
                    al.add(q.poll());
                }
            }

            ans.add(al);
        }

        return ans;
    }


    public void helper(TreeNode root,
                       TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> tm,
                       int col,
                       int row){

        if(root == null)
            return;

        tm.putIfAbsent(col, new TreeMap<>());

        tm.get(col).putIfAbsent(row, new PriorityQueue<>());

        tm.get(col).get(row).add(root.val);


        helper(root.left, tm, col-1, row+1);

        helper(root.right, tm, col+1, row+1);
    }
}