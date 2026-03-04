class Solution {
    public int longestValidParentheses(String s) {
      int max = 0;
        Deque<Integer> stack = new ArrayDeque<>(List.of(-1)); // Base index
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) stack.push(i); // Update base index
                else max = Math.max(max, i - stack.peek());
            }
        }
        return max;  
    }
}
