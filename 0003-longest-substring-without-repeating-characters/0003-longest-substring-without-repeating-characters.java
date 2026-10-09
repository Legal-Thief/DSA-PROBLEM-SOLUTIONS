class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l =0;
        int r= 0;
        int maxLen = 0;
        // HashSet<Character> hs = new HashSet<>();
        int[] hs = new int[256];
        while(r<s.length()){
            char ch= s.charAt(r);
            if(hs[ch]==0){
                hs[ch]++;
                maxLen = Math.max(maxLen, r-l+1);
                r++;
            }else{
                 hs[s.charAt(l)]--;
                l++;
            }
        }

        return maxLen;
    }
}