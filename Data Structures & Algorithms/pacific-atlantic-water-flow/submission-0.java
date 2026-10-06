class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        int r = heights.length;
        int c = heights[r - 1].length;

        for (int i = 0; i < c; i++) {
            dfs(heights, 0, i, pacific);
        }

        for (int i = 0; i < r; i++) {
            dfs(heights, i, 0, pacific);
        }

        for (int i = 0; i < c; i++) {
            dfs(heights, r - 1, i, atlantic);
        }
        for (int i = 0; i < r; i++) {
            dfs(heights, i, c - 1, atlantic);
        }

        Set<List<Integer>> intersection = new HashSet<>(pacific);
        intersection.retainAll(atlantic);

        return List.copyOf(intersection);
    }

    private void dfs(int[][] heights, int i, int j, Set<List<Integer>> set) {
        List<Integer> curr = List.of(i, j);

        if (set.contains(curr)) {
            return;
        }

        set.add(curr);

        // up
        if (i > 0 && heights[i - 1][j] >= heights[i][j]) {
            dfs(heights, i - 1, j, set);
        }

        // left
        if (j > 0 && heights[i][j - 1] >= heights[i][j]) {
            dfs(heights, i, j - 1, set);
        }

        // right
        if (j < heights[i].length - 1 && heights[i][j + 1] >= heights[i][j]) {
            dfs(heights, i, j + 1, set);
        }

        // down
        if (i < heights.length - 1 && heights[i + 1][j] >= heights[i][j]) {
            dfs(heights, i + 1, j, set);
        }
    }
}
