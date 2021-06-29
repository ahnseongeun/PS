package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 더하기사이클_1110 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int target = n;
        int cnt = 0;
        while(true){
            if (n >= 10) {
                int num1 = n / 10;
                int num2 = n % 10;
                int num3 = num1 + num2;
                n = num2 * 10 + num3 % 10;
            } else {
                int num3 = n;
                n = n * 10 + num3 % 10;
            }
            cnt++;
            if(target == n) break;
        }
        System.out.println(cnt);
    }
}
