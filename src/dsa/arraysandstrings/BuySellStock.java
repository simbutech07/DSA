package dsa.arraysandstrings;

public class BuySellStock {
    public static void main() {

        int[] prices = {10,5,28,10,3,7};
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        int buyPrice = 0;
        int sellPrice = 0;

        for (int i = 0;i<prices.length;i++){

            if(prices[i] < minPrice){
                // Update the minimum price seen so far
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){ // Calculate profit if we sell at the current price
                maxProfit = prices[i] - minPrice;

                buyPrice = minPrice;
                sellPrice = prices[i];
            }
        }

        System.out.println("maxProfit : "+maxProfit);

        System.out.println("buyPrice : "+buyPrice);
        System.out.println("sellPrice : "+sellPrice);

    }

}
