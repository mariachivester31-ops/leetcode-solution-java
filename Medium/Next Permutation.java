class Solution {
    public void nextPermutation(int[] nums) {
         int i = nums.length - 2, j = nums.length - 1;
        while (i >= 0 && nums[i] >= nums[i + 1]) i--;
        if (i >= 0) {
            while (nums[j] <= nums[i]) j--;
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
    private void reverse(int[] a, int s) {
        int e = a.length - 1;
        while (s < e) swap(a, s++, e--);
    }
}
