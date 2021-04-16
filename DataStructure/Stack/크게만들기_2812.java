package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
4 2
1924
 */
public class 크게만들기_2812 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int len = n - k;
        String str = input.readLine();

        Stack<Integer> stack = new Stack<>();
        stack.add(str.charAt(0) - '0');

        for (int i = 1; i < n; i++){
            int num = str.charAt(i) - '0';
            while(k > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                k--;

            }
            stack.add(num);
        }
        while(stack.size() > len)
            stack.pop();

        for(int val : stack)
            sb.append(val);
        System.out.println(sb);

    }
}
