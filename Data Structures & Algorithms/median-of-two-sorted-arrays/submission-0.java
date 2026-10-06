class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary-search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int l = 0;
        int r = x;

        int total = x + y;

        while (l <= r) {

            int partx = l + (r - l) / 2;
            int party = (total + 1) / 2 - partx;

            // Boundaries of array1
            int leftX = (partx == 0)
                    ? Integer.MIN_VALUE
                    : nums1[partx - 1];

            int rightX = (partx == x)
                    ? Integer.MAX_VALUE
                    : nums1[partx];

            // Boundaries of array2
            int leftY = (party == 0)
                    ? Integer.MIN_VALUE
                    : nums2[party - 1];

            int rightY = (party == y)
                    ? Integer.MAX_VALUE
                    : nums2[party];

            // Correct partition
            if (leftX <= rightY && leftY <= rightX) {

                // Odd total
                if (total % 2 == 1) {
                    return Math.max(leftX, leftY);
                }

                // Even total
                return (Math.max(leftX, leftY)
                        + Math.min(rightX, rightY)) / 2.0;
            }

            // Too many elements taken from nums1
            if (leftX > rightY) {
                r = partx - 1;
            }

            // Too few elements taken from nums1
            else {
                l = partx + 1;
            }
        }

        return 0.0;
    }
}