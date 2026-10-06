class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int front = 0;
        int back = len-1;

        while (front <= back) {
            int mid = ((back - front) / 2) + front;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                front = mid + 1;
            } else {
                back = mid - 1;
            }
        }

        return -1;
    }
}
