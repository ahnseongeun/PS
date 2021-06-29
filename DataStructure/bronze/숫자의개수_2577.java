package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 숫자의개수_2577 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int dp[] = new int[10];
        int a = Integer.parseInt(input.readLine());
        int b = Integer.parseInt(input.readLine());
        int c = Integer.parseInt(input.readLine());
        String num = String.valueOf(a * b * c);
        for(int i = 0; i < num.length(); i++) dp[num.charAt(i) - '0']++;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 10; i++) sb.append(dp[i]).append("\n");
        System.out.println(sb);
    }
}
