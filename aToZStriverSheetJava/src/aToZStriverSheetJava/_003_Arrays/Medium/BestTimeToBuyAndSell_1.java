package aToZStriverSheetJava._003_Arrays.Medium;

public class BestTimeToBuyAndSell_1 {
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
