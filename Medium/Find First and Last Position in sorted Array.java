public class Solution {

  
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};

        
        int start = findFirstOccurrence(nums, target);

       
        if (start == -1) {
            return result;
        }


        int end = findLastOccurrence(nums, target);

        result[0] = start;
        result[1] = end;
        return result;
    }

   
    private int findFirstOccurrence(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] >= target) {
 
                if (nums[mid] == target) {
                    index = mid;
                }
                right = mid - 1;
            } else {
          
                left = mid + 1;
            }
        }
        return index;
    }

    
    private int findLastOccurrence(int[] nums, int target) {
        int index = -1;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= target) {
     
                if (nums[mid] == target) {
                    index = mid;
                }
                left = mid + 1;
            } else {
               
                right = mid - 1;
            }
        }
        return index;
    }
}
