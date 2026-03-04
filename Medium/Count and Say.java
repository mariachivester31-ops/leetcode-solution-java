
class Solution {
    public String countAndSay(int n) {
       String s = "1";
        while (--n > 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                int count = 1;
                while (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                    count++;
                    i++;
                }
                sb.append(count).append(s.charAt(i));
            }
            s = sb.toString();
        }
        return s; 
    }
}
