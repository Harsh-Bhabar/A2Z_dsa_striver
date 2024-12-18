package aToZStriverSheetJava._003_Arrays;

//link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/

public class Best_Time_To_Buy_And_Sell_1 {
    public int maxProfit(int[] prices) {
        int maxAns = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<prices.length; i++){
            if(prices[i] < min){
                min = prices[i];
            }
            maxAns = Math.max(maxAns, prices[i]-min);
        }

        return maxAns;
    }
}
