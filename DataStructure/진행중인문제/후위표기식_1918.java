package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
E/A*(D*(B+C))
EA/

(A * (B + C)) - (D/E)
ABC+*

A*(E/B+C*D)
AEB/CD'*'/+*
 */

/**
 * 전체적인 로직
 * (를 만나면 스택에 넣어준다. 스택내의 범위 시작 조건
 * )를 만나면 (를 만날때까지 pop진행
 * *,/를 만나면 먼저 들어가 있는 *,/가 우선순위가 높기때문에 모두 제거후 pop
 * +,-를 만나면 stack에 들어 있는 모든 것을 pop *,/,-,+보다 모두 우선순위가 낮기 때문이다.
 * 글자를 만나면 그냥 넣어준다.
 */
public class 후위표기식_1918 {

    private static String getTransFormation(String str) {

        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                stack.add(ch);
            }else if(ch ==')'){
                while(!stack.isEmpty() && stack.peek() != '(')
                    sb.append(stack.pop());
                stack.pop();
            }else if(ch == '*' || ch == '/'){
                //ch가 *,- 라면 먼저 들어있는 *,/를 모두 제거한다.(먼저 들어가 있는 것이 우선순위가 높으니깐)
                while(!stack.isEmpty() && (stack.peek() == '*' || stack.peek() == '/')){
                    sb.append(stack.pop());
                }
                stack.add(ch);
            }else if(ch == '+' || ch == '-'){
                //ch가 +,-라면 ( 만날때 까지 스택에서 모든 것을 제거
                while(!stack.isEmpty() && stack.peek() != '('){
                    sb.append(stack.pop());
                }
                stack.add(ch);
            }else{ //글자
                sb.append(ch);
            }
        }
        while(!stack.isEmpty())
            sb.append(stack.pop());
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        System.out.println(getTransFormation(str));
    }
}
