class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> sol = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // Since array is sorted, no triplet can sum to 0 after this.
            if (nums[i] > 0)
                break;

            // Skip duplicate first elements
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int target = -nums[i];
            int front = i + 1;
            int back = nums.length - 1;

            while (front < back) {

                int sum = nums[front] + nums[back];

                if (sum == target) {

                    sol.add(Arrays.asList(nums[i], nums[front], nums[back]));

                    front++;
                    back--;

                    // Skip duplicate second element
                    while (front < back && nums[front] == nums[front - 1])
                        front++;

                    // Skip duplicate third element
                    while (front < back && nums[back] == nums[back + 1])
                        back--;

                } else if (sum < target) {
                    front++;
                } else {
                    back--;
                }
            }
        }

        return sol;
    }
}