class Solution {
    public int divide(int dividend, int divisor) {
    if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        long a = Math.abs((long)dividend), b = Math.abs((long)divisor), res = 0;
        for (int i = 31; i >= 0; i--) {
            if ((a >> i) >= b) {
                res += 1L << i;
                a -= b << i;
            }
        }
        return (dividend > 0) == (divisor > 0) ? (int)res : (int)-res;    
    }
}
