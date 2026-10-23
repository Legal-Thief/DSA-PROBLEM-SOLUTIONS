class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans =new ArrayList<>();
        helper(n, k, 1, ans, new ArrayList<>());
        return ans;   
    }
    public void helper(int n, int k,int start,List<List<Integer>> ans,List<Integer> temp){
        if(k==temp.size()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        if (start > n) {
            return;
        }

            temp.add(start);
            helper(n,k,start+1,ans,temp);
            temp.remove(temp.size()-1);
            helper(n,k,start+1,ans,temp);
    }
}