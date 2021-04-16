package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
E/A*(D*(B+C))
(A+B*C)
(A*B+C)
 */

/**
 * 괄호안의 +,* 이렇게 우선순위가 있을 때 어떻게 처리해야할까?
 *
 */
public class 후위표기식_1918 {

    private static int calNum(char ch) {
        if(ch == '+' || ch == '-')
            return 1;
        return 2;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String str = input.readLine();

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '/' || ch == '*' || ch == '+' || ch == '-'){

                //새로 들어온 것이 더 높다면 stack push, 기존 것이 더 높더면 * + pop해서 넣고 push
                temp = new StringBuilder();
                while(!stack.isEmpty() && calNum(stack.peek()) > calNum(ch)){
                    if(stack.peek() == '(')
                        break;
                    temp.append(stack.pop());
                }
                stack.push(ch);
            }else if(ch == '('){
                stack.push(ch);
            }else if(ch == ')'){
                sb.append(temp.toString());
                while (!stack.isEmpty()){
                    char tmp = stack.peek();
                    if(tmp == '(') {
                        stack.pop();
                        break;
                    }
                    sb.append(stack.pop());
                }
            }else{
                sb.append(ch);
            }
        }
        while(!stack.isEmpty()){
            char tmp = stack.pop();
            if(tmp == '(')
                continue;
            sb.append(tmp);
        }
        System.out.println(sb);
    }
}
