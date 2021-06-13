package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
3
config.sys
config.inf
configures
 */
public class 명령프롬프트 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        char[] str = input.readLine().toCharArray();
        for(int i = 1; i < n; i++){
            String compare = input.readLine();
            for(int j = 0; j < str.length; i++){
                if(str[j] != compare.charAt(j))
                    str[j] = '?';
            }

        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length; i++)
            sb.append(str[i]);
        System.out.println(sb);
    }
}
