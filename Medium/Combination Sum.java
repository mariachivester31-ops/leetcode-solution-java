class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    private void backtrack(List<List<Integer>> res, List<Integer> temp, int[] nums, int remain, int start) {
        if (remain < 0) return;
        if (remain == 0) res.add(new ArrayList<>(temp));
        else {
            for (int i = start; i < nums.length; i++) {
                temp.add(nums[i]);
                backtrack(res, temp, nums, remain - nums[i], i); // 'i' not 'i+1' to reuse same element
                temp.remove(temp.size() - 1);
            }
        }
    }
}
