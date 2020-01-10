// https://leetcode.com/problems/best-time-to-buy-and-sell-stock

class Solution {
    public int maxProfit(int[] prices) {
        int maxProf = 0;
        int minPrice = Integer.MAX_VALUE;

        for (int i = 0; i < prices.length; i++) {
		if(prices[i] < minPrice)
			minPrice = prices[i];
		else if(prices[i] - minPrice > maxProf)
			maxProf = prices[i] - minPrice;
	}
        return maxProf;
    }
}
