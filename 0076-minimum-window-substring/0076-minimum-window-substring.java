
class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length() || t.isEmpty()) return "";

        int[] freq = new int[128];

        for (char ch : t.toCharArray()) {
            freq[ch]++;
        }

        int left = 0, required = t.length();
        int start = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);

            if (freq[ch] > 0) required--;
            freq[ch]--;

            while (required == 0) {
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    start = left;
                }

                char leftChar = s.charAt(left++);
                freq[leftChar]++;

                if (freq[leftChar] > 0) required++;
            }
        }

        return minLen == Integer.MAX_VALUE
                ? ""
                : s.substring(start, start + minLen);
    }
}
