package CodingTest.네이버웹툰;

import java.util.Arrays;

public class Test1 {

    private static int getPrice(int[] prices, int[] discounts){
        int sum = 0;
        Arrays.sort(prices);
        Arrays.sort(discounts);
        //price먼저
        int idx = discounts.length - 1;
        for(int i = prices.length - 1; i >= 0; i--){
            int price = prices[i];
            if(idx == -1) sum += price;
            else sum += Math.round(price * (1 - (discounts[idx--] / 100.0)));
        }
        return sum;
    }

    public static int solution(int[] prices, int[] discounts) {
        return getPrice(prices, discounts);
    }
    public static void main(String[] args) {
        int prices[] = {13000, 88000, 10000};
        int discounts[] = {30, 20};
        int result = solution(prices,discounts);
        System.out.println(result);
    }
}
