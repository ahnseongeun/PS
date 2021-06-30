package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//()()()))(
public class 그릇_7567 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        int sum = 10;
        for(int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) sum += 5;
            else sum += 10;
        }
        System.out.println(sum);
    }
}
