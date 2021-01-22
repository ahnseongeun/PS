package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//1 6 12 24 48
/*
1
1 + 6 = 7
7 + 12 = 19
19 + 18 = 37
37 + 24 = 61
 */
public class 벌집_2292 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int start = 2;
        int val = 6;
        int end = 7;
        int count = 2;
        if(n == 1) {
            count = 1;
        }else {
            while (true) {
                if (start <= n && end >= n) {
                    break;
                }
                start += val;
                val += 6;
                end += val;
                count++;
            }
        }
        System.out.println(count);
    }
}
