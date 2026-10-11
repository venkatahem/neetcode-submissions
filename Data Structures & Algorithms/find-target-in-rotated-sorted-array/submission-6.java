class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;

        int front = 0;
        int back = len - 1;

        while (front <= back) {
            int mid = ((back - front) / 2) + front;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[front] > nums[back]) {
                // search range is rotated

                if (nums[front] <= nums[mid]) {
                    // we are in left part of rotated array
                    if (target < nums[mid] && target >= nums[front]) {
                        back = mid - 1;
                    } else {
                        front = mid + 1;
                    }
                } else {
                    // right part of rotated array
                    if (target > nums[mid] && target <= nums[back]) {
                        front = mid + 1;
                    } else {
                        back = mid - 1;
                    }
                }

            } else {
                // search range is sorted :: binary search
                if (target < nums[mid]) {
                    back = mid - 1;
                } else {
                    front = mid + 1;
                }
            }
        }

        return -1;
    }
}
