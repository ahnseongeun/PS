package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_30_10610 {

    private static boolean check(char[] str){

        int num = 0;
        for(char ch : str) num += (ch - '0');
        return num % 3 == 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        char[] str = input.readLine().toCharArray();
        int result = -1;
        Arrays.sort(str);
        if(str[0] == '0' && check(str)) {
            StringBuilder sb = new StringBuilder(new String(str));
            System.out.println(sb.reverse());
        } else {
            System.out.println(result);
        }
    }
}
