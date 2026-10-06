class Solution {
    public int findMin(int[] nums) {
        //[3,4,5,6,1,2]
        //[4,5,0,1,2,3]
        //[5,0,1,2,3,4]
        //[0,1,2,3,4,5]
        // l-0,r-5,m-2
        // 3 < 5 > 2 -> right
        // 4 < 5 < 7 -> left
        // 5 > 1 < 4 -> left
        int len = nums.length;

        int l = 0;
        int r = len - 1;

        int sol = 0;

        while (l <= r) {
            if (nums[l] <= nums[r]) {
                sol = nums[l];
                break;
            }
            int mid = ((r - l) / 2) + l;
            // System.out.println("l - " + l + " mid - " + mid + " r - " + r);

            if (nums[(mid - 1 + len) % len] > nums[mid] && nums[mid] < nums[(mid + 1) % len]) {
                sol = nums[mid];
                break;
            } else if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return sol;
    }
}
