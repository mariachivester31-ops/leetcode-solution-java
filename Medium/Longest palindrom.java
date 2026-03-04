class Solution {
    private int maxLen = 0;
    private int startIdx = 0;
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);
            expandAroundCenter(s, i, i + 1);
        }
        return s.substring(startIdx, startIdx + maxLen);
    }
    private void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        int currentLen = right - left - 1;
        if (currentLen > maxLen) {
            maxLen = currentLen;
            startIdx = left + 1;
        }
    }
    public static void main(String[] args) {
        Solution sol1 = new Solution();
        String s1 = "babad";
        System.out.println("Input: \"" + s1 + "\" | Longest Palindromic Substring: \"" + sol1.longestPalindrome(s1) + "\""); 

        Solution sol2 = new Solution();
        String s2 = "cbbd";
        System.out.println("Input: \"" + s2 + "\" | Longest Palindromic Substring: \"" + sol2.longestPalindrome(s2) + "\"");
    }
}
