class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        if (s.isEmpty() || words.length == 0) return ans;
        int n = words.length, len = words[0].length();
        Map<String, Integer> count = new HashMap<>();
        for (String w : words) count.merge(w, 1, Integer::sum);
        for (int i = 0; i <= s.length() - n * len; i++) {
            Map<String, Integer> seen = new HashMap<>();
            int j = 0;
            for (; j < n; j++) {
                String word = s.substring(i + j * len, i + j * len + len);
                if (!count.containsKey(word) || seen.merge(word, 1, Integer::sum) > count.get(word)) break;
            }
            if (j == n) ans.add(i);
        }
        return ans;
    }
}
