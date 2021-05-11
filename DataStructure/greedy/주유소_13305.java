package DataStructure.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4
2 3 1
5 2 4 1
 */
public class 주유소_13305 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int price[] = new int[n];
        int path[] = new int[n - 1];
        StringTokenizer st = new StringTokenizer(input.readLine());

        for(int i = 0; i < n - 1; i++) {
            path[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++)
            price[i] = Integer.parseInt(st.nextToken());

        long min = price[0];
        long total_price = min * path[0];
        for(int i = 1; i < n - 1; i++){
            min = Math.min(min, price[i]);
            total_price += min * path[i];
        }
        System.out.println(total_price);
    }
}
