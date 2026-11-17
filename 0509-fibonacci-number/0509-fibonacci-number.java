class Solution {
    static int[] dp;
    public int f(int n){
        if(n<=1) return n;
        if(dp[n]!=0) return dp[n];
        dp[n] = f(n-1)+f(n-2);
        return dp[n];
    }
    public int fib(int n) {
        dp = new int[n+1];
        return f(n);
    }
}