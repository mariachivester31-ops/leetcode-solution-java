class Solution 
{
    private void fun(int[] nums,List<Integer> temp,List<List<Integer>> ans,int idx)
    {
        if(idx==nums.length)
        {
            ans.add(new ArrayList<>(temp));
            return; 
        }
         
        temp.add(nums[idx]);
        fun(nums,temp,ans,idx+1);
        temp.remove(temp.size()-1);
        while(idx+1<nums.length&&nums[idx]==nums[idx+1])
        {
            idx++;
        } 
        fun(nums,temp,ans,idx+1);
        return;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) 
    {
        Arrays.sort(nums);
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        fun(nums,temp,ans,0);
        return ans;
    }
//please upvote... 
}
