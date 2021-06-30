package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class KMP는왜KMP일까_2902 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(str,"-");
        while(st.hasMoreTokens()) sb.append(st.nextToken().charAt(0));
        System.out.println(sb);
    }
}
