package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class iSharp_3568 {
    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String[] str = input.readLine().split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = 1 ; i < str.length; i++){

            int index = 0;
            for(int j = 0; j < str[i].length(); j++){
                char ch = str[i].charAt(j);
                if(ch == '*' || ch == '[' || ch == '&' || ch == ',' || ch == ';')
                    break;
                index++;
            }
            String reverseStr = str[i].substring(index, str[i].length() - 1);
            reverseStr = reverseString(reverseStr);
            sb.append(str[0]).append(reverseStr).append(" ").append(str[i].substring(0, index));
            sb.append(";\n");
        }
        System.out.println(sb);
    }

    private static String reverseString(String reverseStr) {

        StringBuilder sb = new StringBuilder();
        for(int i = reverseStr.length() - 1; i >= 0; i--){
            char ch = reverseStr.charAt(i);
            if(ch == '&' || ch == '*')
                sb.append(ch);
            else
                sb.append(reverseStr.charAt(i - 1)).append(reverseStr.charAt(i--));
        }
        return sb.toString();
    }
}
