package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class 균형잡힌세상 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;
        while(!(str = input.readLine()).equals(".")){
            Stack<Character> stack = new Stack<>();
            for(int i = 0; i < str.length(); i++){
                char ch = str.charAt(i);
                if(ch == '(' || ch == '['){
                    stack.push(ch);
                }else if(ch == ')' || ch == ']'){
                    if(stack.isEmpty()){
                        sb.append("no\n");
                        break;
                    }
                    if(ch == ')' && stack.pop() != '('){
                        sb.append("no\n");
                        break;
                    }
                    if(ch == ']' && stack.pop() != '['){
                        sb.append("no\n");
                        break;
                    }
                }else{
                    if(ch == '.') {
                        if(stack.isEmpty())
                            sb.append("yes\n");
                        else
                            sb.append("no\n");
                    }
                }
            }
        }
        input.close();
        System.out.println(sb);
    }
}
