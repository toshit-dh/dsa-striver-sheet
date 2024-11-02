package Array;

public class StockBuySell {

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            }
            int profit = price - minPrice;
            if (profit > maxProfit) {
                maxProfit = profit;
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 6, 5, 3, 6, 4})); // Output: 3
    }
}
