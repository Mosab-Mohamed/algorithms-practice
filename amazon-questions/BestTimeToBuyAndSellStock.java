// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        for (int i = 0; i < prices.length; i++) {
			for (int j = i+1; j < prices.length; j++) {
				if(prices[j] > prices[i] && maxProf < prices[j] - prices[i])
					maxProf = prices[j] - prices[i];
			}
		}
        return maxProf;
    }
}
