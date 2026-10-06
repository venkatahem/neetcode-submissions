class Solution {
    public int maxProfit(int[] prices) {
        // Base case: if there are no prices or only one price, no profit can be made
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int maxProfit = 0;
        int minPrice = prices[0]; // Track the lowest price seen so far

        // Single pass from left to right
        for (int i = 1; i < prices.length; i++) {
            // Update minPrice if the current price is lower
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                // Calculate potential profit and update maxProfit if it's higher
                int currentProfit = prices[i] - minPrice;
                maxProfit = Math.max(maxProfit, currentProfit);
            }
        }

        return maxProfit;
    }
}
