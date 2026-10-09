class Solution {
    public int characterReplacement(String s, int k) {
        int[] hash = new int[26];
        int l = 0;
        int max = 0;
        int maxfreq = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            hash[ch - 'A']++;
            maxfreq = Math.max(maxfreq, hash[ch - 'A']);
            while ((i - l + 1) - maxfreq > k) {
                hash[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}