class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char n = board[i][j];
                if (n != '.') {
                    if (!seen.add(n + "r" + i) || 
                        !seen.add(n + "c" + j) || 
                        !seen.add(n + "b" + i/3 + j/3)) return false;
                }
            }
        }
        return true;
    }
}
