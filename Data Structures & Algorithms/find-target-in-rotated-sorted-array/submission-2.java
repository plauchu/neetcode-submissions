class Solution {
    public int search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;

            if (nums[lo] <= nums[mid]) {              // izquierda ordenada
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;                     // cae dentro
                } else {
                    lo = mid + 1;                     // no cae: a la otra
                }
            } else {                                  // derecha ordenada
                if (nums[mid] < target && target <= nums[hi]) {
                    lo = mid + 1;                     // cae dentro
                } else {
                    hi = mid - 1;                     // no cae: a la otra
                }
            }
        }

        return -1;
    }
}