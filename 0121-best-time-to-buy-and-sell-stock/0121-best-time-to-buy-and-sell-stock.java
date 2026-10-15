class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n==1) return 0;
        int profit = 0;
        int min = prices[0];
        for(int i=1;i<n;i++){
            min=Math.min(min,prices[i-1]);
            profit = Math.max(profit,prices[i]-min);

        }
        return profit;


        
    }
}