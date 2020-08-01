package practice.week5;

public class Day1_BuyAndSellStockWithCooldown {
    /*
    we have 2 case stock on day i and no stock on day i
    -> stock on day i, represented by dp[i][1], then max of
        ->bought today
            dp[i-2][0] - prices[i]
        ->carry forward yesterday
            dp[i-1][1]

    -> no stock on day i, represented by dp[i][0], then max of
        -> sold today, bought yesterday or day before
            dp[i-1][1] + prices[i]
        -> carry forward yesterday or it is coolday today
            dp[i-1][0]
    **/

    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (prices == null || len <= 1) return 0;
        if (len ==2 && prices[1] > prices[0]) return prices[1] - prices[0];
        if (len == 2 && prices[1] < prices[0]) return 0;

        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
        dp[1][1] = Math.max(dp[0][1], dp[0][0] - prices[1]);

        for (int i=2; i<len; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-2][0] - prices[i]);
        }
        // we want max profit means sold everything bought
        return dp[len-1][0];
    }
}
