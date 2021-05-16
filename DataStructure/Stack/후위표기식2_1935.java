package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/*
5
ABC*+DE/-
1
2
3
4
5
 */
public class 후위표기식2_1935 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String str = input.readLine();
        HashMap<Character,Integer> map = new HashMap();
        for(int i = 0; i < n; i++)
            map.put((char) ('A' + i), Integer.parseInt(input.readLine()));

        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(map.get(ch) == null) {
                double val1 = stack.pop();
                double val2 = stack.pop();
                if (ch == '*') {
                    stack.add(val2 * val1);
                } else if (ch == '/'){
                    stack.add(val2 / val1);
                } else if (ch == '-') {
                    stack.add(val2 - val1);
                } else if (ch == '+'){
                    stack.add(val2 + val1);
                }
            }else {
                stack.add(Double.valueOf(map.get(ch)));
            }
        }
        System.out.printf("%.2f",stack.pop());
    }
}