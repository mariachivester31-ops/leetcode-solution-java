class Solution {
    Map<Integer, Integer> memo = new HashMap<>();
    
    public int numTrees(int n) {
        if(n==0 || n==1){
            return 1;
        }
        if(memo.containsKey(n)){
            return memo.get(n);
        }
        int sum =0; 
        for(int i=1; i<=n; i++){
            sum += numTrees(i-1)*numTrees(n-i);    
        }
        memo.put(n,sum);    
        return sum;
    }
}
