package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//123 100
public class 뒤집힌덧셈_1357 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int n2 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        System.out.println(Integer.parseInt(String.valueOf(new StringBuilder(String.valueOf((n1 + n2))).reverse())));
    }
}
