class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            int t= target- nums[i];
            if(hm.containsKey(t)){
                return new int[]{hm.get(t),i+1};
            }
            hm.put(nums[i],i+1);
        }
        return new int[]{};
    }
}