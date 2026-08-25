class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            int j = i + 1;
            while(j < prices.length) {
                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
                j++;
            }        
        }

        return maxProfit;
    }
}
