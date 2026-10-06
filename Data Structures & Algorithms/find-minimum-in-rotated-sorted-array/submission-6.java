class Solution {
    public int findMin(int[] nums) {
        int len = nums.length;

        int back = len - 1;
        int front = 0;

        while (front <= back) {
            int mid = ((back - front) / 2) + front;

            int left = (len + mid - 1) % len;
            int right = (mid + 1) % len;

            // System.out.println("F - " + front + " - B - " + back + " - M - " + mid + " - L - " + left + " - R - " + right);
            // System.out.println("NL - " + nums[left] + " - NM - " + nums[mid] + " - NR - " + nums[right]);
            if (nums[left] > nums[mid] && nums[mid] < nums[right]) {
                return nums[mid];
            }

            // System.out.println("NF - " + nums[front] + " - NM - " + nums[mid] + " - NB - " + nums[back]);

            if (nums[mid] > nums[back]) {
                front = mid + 1;
            } else {
                back = mid - 1;
            }
        }

        return nums[front];
    }
}
