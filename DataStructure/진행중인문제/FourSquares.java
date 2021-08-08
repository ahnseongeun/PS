package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class FourSquares {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        int cnt = 0;
        while(n != 0) {
            int num = (int) Math.sqrt(n);
            n -= (num * num);
            System.out.println(n);
            cnt++;
        }
        System.out.println(cnt);
    }
}
