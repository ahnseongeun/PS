package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
8
4
3
6
8
7
5
2
1
 */

/**
 어떻게 접근 할 것인가?
 목표하는 값 까지 stack에 삽입한다.
 4까지 삽입 4를 목표하는 수 까지 만났다면 pop 진행
 다음 목표하는 수가 4보다 작다면 pop진행 -> 만족 할 수 없다면 NO
 다음 목표하는 수가 4보다 크다면 다시 push 진행
 기본적으로 O(N)에 문제를 풀기 원한다.
 */
public class 스택수열_1874 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int target = Integer.parseInt(input.readLine());

        for(int i = 1 ; i <= n; i++){
           // target 과 i 가 같다면 - 해주고 while문을 통해서 - 할수 있는 만큼 하기
           if(target == i){
               stack.push(i);
               sb.append("+\n");
               while(!stack.isEmpty() && stack.peek() == target){
                   stack.pop();
                   sb.append("-\n");
                   if(stack.isEmpty() && i == n)
                       break;
                   target = Integer.parseInt(input.readLine());
               }
           }else{ // target 과 i가 같지 않다면 + 해주기
                stack.push(i);
                sb.append("+\n");
           }
        }

        if(stack.isEmpty())
            System.out.println(sb);
        else
            System.out.println("NO");
    }
}
