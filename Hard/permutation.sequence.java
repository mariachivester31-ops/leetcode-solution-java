class Solution {
    public String getPermutation(int n, int k) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<=n;i++){
            sb.append(i);
        }
        String str=sb.toString();
        ArrayList<String> arr=new ArrayList<>();
        permutate(str.toCharArray(),0,n-1,arr);
        Collections.sort(arr);
        return arr.get(k-1);
    }
    static void permutate(char[] ch,int l,int r,ArrayList<String> arr){
        if(l==r){
            arr.add(new String(ch));
            return;
        }
        for(int i=l;i<=r;i++){
            swap(ch,i,l);
            permutate(ch,l+1,r,arr);
            swap(ch,i,l);
        }
    }
    static void swap(char[] arr,int i,int e){
        char temp=arr[i];
        arr[i]=arr[e];
        arr[e]=temp;
    }
}
