package arrays.easy;

public class BestTimeToBuyAndSellStock {

    //BRUTE FORCE APPROACH-----------------------------------------------------------------------------------------
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mini = prices[0];
    int maxP = 0;

        for(
    int i = 0;
    i<n;i++)

    {
        for (int j = i + 1; j < n; j++) {
            if (prices[i] < prices[j]) ;
            maxP = Math.max(maxP, prices[j] - prices[i]);
        }
    }
        return maxP;

}
}





    //OPTIMAL APPROACH KIND A DP-----------------------------------------------------------------------------------
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int mini = prices[0];
        int maxP = 0;

        for(int i =1; i < n; i++){
            int cost = prices[i] - mini;
            maxP = Math.max(maxP, cost);
            mini = Math.min(mini, prices[i]);
        }
        return maxP;
    }
}
