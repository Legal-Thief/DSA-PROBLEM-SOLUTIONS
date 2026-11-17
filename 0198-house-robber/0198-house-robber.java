class Solution {
    static int dp[];
    public int rob(int[] nums) {
       dp= new int[nums.length];
       Arrays.fill(dp, -1);
       return fun(0,nums); 
    }
    public int fun(int i,int[] nums){
        if(i>=nums.length) return 0;
        if(dp[i]!=-1) return dp[i];
        int pick = nums[i]+fun(i+2,nums);
        int skip = fun(i+1,nums);
        dp[i]=Math.max(pick, skip);
        return dp[i];
    }
}