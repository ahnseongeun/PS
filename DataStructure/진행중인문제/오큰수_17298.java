package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
4
3 5 2 7
7 2 5 3

2 3 5 3
2
내림차순으로 스택을 쌓는다.
 */
public class 오큰수_17298 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> orderByDesc = new Stack<>();
        Stack<Integer> result = new Stack<>();


        while(st.hasMoreTokens())
            stack.add(Integer.parseInt(st.nextToken()));

        //for(int i = 1000000; i > 0 ; i--)
        //    stack.add(i);

        while(!stack.isEmpty()){
            int val = stack.pop();
            while(!orderByDesc.isEmpty() && orderByDesc.peek() <= val){
                orderByDesc.pop();
            }
            if(orderByDesc.isEmpty()){
                result.push(-1);
            }else{
                result.push(orderByDesc.peek());
                //sb.insert(0,orderByDesc.peek() + " ");
            }
            orderByDesc.push(val);
        }
        while(!result.isEmpty()){
            sb.append(result.pop()).append(" ");
        }
        System.out.println(sb.substring(0,sb.length() - 1));
    }
}
