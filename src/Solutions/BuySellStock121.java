package Solutions;

public class BuySellStock121 {

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};

        System.out.println(maxProfit(prices));
    }

//    First you need to pick some day to buy the stock
//    Secondly you need to pick a day after that to sell the stock

//    Simple solution: Brute Force
    public static int maxProfitBruteForce(int[] prices) {
        int biggestValue = 0;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if(prices[j] - prices[i] > biggestValue ){
                    biggestValue = prices[j] - prices[i];
                }
            }
        }
        return biggestValue;
    }

    // Single Traversal – O(n) time and O(1) space
    public static int maxProfit(int[] prices) {
        int minimum = Integer.MAX_VALUE;
        int biggestDifference=0;
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] - minimum > biggestDifference){
                biggestDifference = prices[i] - minimum;
            }
            if(prices[i] < minimum){
                minimum=prices[i];
            }
        }
        return biggestDifference;
    }
}
