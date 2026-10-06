class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums) {
            set.add(i);
        }

        int count = 0;

        for (Integer i : set) {
            if (set.contains(i - 1)) {
                continue;
            }

            int temp = 0;

            int next = i;

            while (set.contains(next)) {
                temp++;
                next++;
            }

            count = Math.max(count, temp);
        }

        return count;
    }
}
