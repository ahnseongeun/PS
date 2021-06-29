package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2
I am happy today
We want to win the first prize
 */
public class 단어뒤집기_9093 {
    private static String reverse(char[] str) {
        for(int i = 0; i < str.length / 2; i++){
            char ch = str[i];
            str[i] = str[str.length - 1 - i];
            str[str.length - 1 - i] = ch;
        }
        return new String(str);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            while(st.hasMoreTokens()) sb.append(reverse(st.nextToken().toCharArray())).append(" ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
