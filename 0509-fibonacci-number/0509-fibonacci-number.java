class Solution {
    static int dp[];
    public int fib(int n) {
        dp =new int[n+1];
        return sol(n);
    }
    public int sol(int n){
        if(n<1){
            return 0;
        }
        if(n==1) return 1;
        if(dp[n]!=0) return dp[n];

        return dp[n]= sol(n-1) + sol(n-2);
    }
}