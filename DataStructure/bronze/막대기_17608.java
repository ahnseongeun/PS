package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
6
6
9
7
6
4
6
 */
public class 막대기_17608 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.parseInt(input.readLine()));
        for(int i = 1; i < n; i++) {
            int number = Integer.parseInt(input.readLine());
            while(!stack.isEmpty() && stack.peek() <= number) stack.pop();
            stack.push(number);
        }
        System.out.println(stack.size());
    }
}
