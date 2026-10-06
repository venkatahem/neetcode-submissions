class Solution {
    public int maxProfit(int[] prices) {

        int buy = 0;
        int sell = 1;

        int n = prices.length;


        int profit = 0;

        while(buy<sell && sell < n){
            if(prices[sell] < prices[buy]){
                buy = sell;
                sell++;
                continue;
            }

            profit = Math.max(profit,prices[sell]-prices[buy]);
            sell++;
        }
        
        return profit;
    }
}
