class Solution {
    public int numDistinct(String s, String t) {
        return count(s.length() - 1, t.length() - 1, s, t);
    }

    private int count(int i, int j, String s, String t) {

        if (j < 0) return 1;
        if (i < 0) return 0;

        if (s.charAt(i) == t.charAt(j))
            return count(i - 1, j - 1, s, t)
                 + count(i - 1, j, s, t);

        return count(i - 1, j, s, t);
    }
}
