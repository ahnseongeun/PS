package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
7
1 1 2 3 4 2 1
 */
public class 오등큰수_17299 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] dp = new int[1000001];
        int[] arr = new int[n + 1];
        int[] result = new int[n + 1];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dp[arr[i]]++;
        }


        Stack<Integer> stack = new Stack<>();
        for(int i = n; i > 0; i--) {
            while(!stack.isEmpty() && dp[stack.peek()] <= dp[arr[i]]) stack.pop();
            if(stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();
            stack.push(arr[i]);
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(result[i]).append(" ");
        System.out.println(sb);
    }
}
