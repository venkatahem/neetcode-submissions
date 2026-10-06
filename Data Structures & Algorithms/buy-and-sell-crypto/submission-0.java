class Solution {
    public int maxProfit(int[] prices) {

        int[] nextBest = new int[prices.length];

        Stack<Integer> maxStack = new Stack<>();

        for(int i=prices.length-1; i>=0; i--){
            while(!maxStack.empty() && maxStack.peek() <= prices[i]){
                maxStack.pop();
            }
            if(!maxStack.empty()){
                nextBest[i] = maxStack.peek();
            }else{
                nextBest[i] = -1;
                maxStack.push(prices[i]);
            }

        }

        int sol = 0;

        for(int i=0; i<prices.length; i++){
            if(nextBest[i] != -1){
                int val = nextBest[i] - prices[i];
                sol = Math.max(val,sol);
            }
        }

        return sol;
        
    }
}
