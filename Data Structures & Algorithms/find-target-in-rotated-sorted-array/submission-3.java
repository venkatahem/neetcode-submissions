class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0;
        int r = len - 1;

        while (l <= r) {
            int mid = ((r - l) / 2) + l;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[l] <= nums[mid]) {
                if (nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
