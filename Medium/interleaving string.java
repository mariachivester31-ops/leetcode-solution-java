class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length()>s3.length())return false;
        Boolean memo[][]=new Boolean[s1.length()+1][s2.length()+1];
       return recursion(0,0,0,s1,s2,s3,memo);
    }
    public boolean recursion(int l,int r,int i,String s1,String s2,String s3,Boolean memo[][]){
        if(i==s3.length() && l==s1.length() && r==s2.length()){
            return true;
        }
        if(l>s1.length() || r>s2.length() || i>s3.length()){
            return false;
        }
        if (memo[l][r] != null) return memo[l][r];
        boolean ans=false;
        boolean ans1=false;
        if(l<s1.length() && r<s2.length() && s3.charAt(i)==s1.charAt(l) && s3.charAt(i)==s2.charAt(r)){
            ans=recursion(l+1,r,i+1,s1,s2,s3,memo);
            ans1=recursion(l,r+1,i+1,s1,s2,s3,memo);
        }else if(l<s1.length() && s3.charAt(i)==s1.charAt(l)){
            ans=recursion(l+1,r,i+1,s1,s2,s3,memo);
        }else if(r<s2.length() && s3.charAt(i)==s2.charAt(r)){
            ans1=recursion(l,r+1,i+1,s1,s2,s3,memo);
        }
        memo[l][r]=(ans || ans1);
        return (ans || ans1);
    }
}
