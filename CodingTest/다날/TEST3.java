package CodingTest.다날;

import JAVA.문자열_TO_INT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
gold_prices	result
[2, 5, 1, 3, 4]	4
[7, 2, 5, 6, 1, 4, 2, 8]	10
 */
public class TEST3 {

    public static void main(String[] args) throws Exception{
        int gold_prices[] = {7, 2, 5, 6, 1, 4, 2, 8};
        int n = gold_prices.length;
        int dp[] = new int[n];
        int gold = gold_prices[0];

        for(int i = 1; i < n; i++){
            if(gold >= gold_prices[i]){
                continue;
            }else{
                System.out.println("test");
                if(i + 3 < n ){
                    if(gold >= gold_prices[i + 3]){
                        dp[i] = gold_prices[i + 1] - gold;
                        gold = 0;
                    }else{
                        dp[i] = gold_prices[i + 3] - gold;
                        i += 3;
                    }
                }
            }
        }
        for(int a: dp)
            System.out.println(a);
    }
}