class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> sol = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int target = -1 * nums[i];

            int front = i + 1;
            int back = nums.length - 1;

            while (front < back) {
                while (front < back && nums[front] + nums[back] > target) {
                    back--;
                }
                while (front < back && nums[front] + nums[back] < target) {
                    front++;
                }
                if (front != back && nums[front] + nums[back] == target) {
                    sol.add(List.of(nums[i], nums[front], nums[back]));

                    front++;
                    back--;

                    while (front < back && nums[front] == nums[front - 1]) {
                        front++;
                    }
                    while (front < back && nums[back] == nums[back + 1]) {
                        back--;
                    }
                }
            }
        }

        return sol;
    }
}
