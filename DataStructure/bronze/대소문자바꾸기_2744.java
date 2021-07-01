package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class 대소문자바꾸기_2744 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = input.readLine();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch >= 'a' && ch <= 'z') sb.append((char)(ch - 32));
            else sb.append((char)(ch + 32));
        }
        System.out.println(sb);
    }
}
