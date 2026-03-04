class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes. 
        // Also, if last digit is 0, first must be 0 (only possible for 0)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversed = 0;
        int original = x;
        while (x > 0) {
            int digit = x % 10;
            if (reversed > (Integer.MAX_VALUE - digit) / 10) {
                return false; 
            }
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }
}
