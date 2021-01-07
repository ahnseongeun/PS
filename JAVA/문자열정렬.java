package JAVA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열정렬 {
    private static String DescendingString(String str) {
        char ch[]=str.toCharArray();
        Arrays.sort(ch);
        return new StringBuilder(new String(ch)).reverse().toString();
    }

    private static String AscendingStr(String str) {
        char ch[]=str.toCharArray();
        Arrays.sort(ch);
        return new StringBuilder(new String(ch)).toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        String descendingStr= DescendingString(input.readLine());
        System.out.println(descendingStr);
        String ascendingStr= AscendingStr(descendingStr);
        System.out.println(ascendingStr);
    }
}
