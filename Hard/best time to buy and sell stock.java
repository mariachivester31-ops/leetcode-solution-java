
class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] r=new int[n],l=new int[n];
        compute(l,r,prices);
        int ans=l[n-1];
        for(int i=0;i<n-1;i++) ans=Math.max(l[i]+r[i+1],ans);
        return ans;
    }
    public void compute(int[] l,int[] r,int[] prices){
        int n=prices.length;
        int ans=0;
        int min=prices[0];
        for(int i=0;i<n;i++){
            ans=Math.max(ans,prices[i]-min);
            min=Math.min(prices[i],min);
            l[i]=ans;
        }
        ans=0;
        int max=prices[n-1];
        for(int i=n-1;i>=0;i--){
            ans=Math.max(ans,max-prices[i]);
            max=Math.max(prices[i],max);
            r[i]=ans;
        }
    }
}
