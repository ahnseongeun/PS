package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//(()[[]])([])
//2 * 2
//[(26]
public class 괄호의값_2504 {

    private static int getStack(String str) {

        Stack<Integer> stack = new Stack<>();
        int result = 0;
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < str.length(); i++){
            int ch = str.charAt(i);
            if (ch == '('){
                stack.add(-1);
                cnt1++;
            } else if(ch == '['){
                stack.add(-2);
                cnt2++;
            } else if (ch == ')'){
                int temp = 0;
                if(cnt1 == 0) return 0;
                while(!stack.isEmpty() && stack.peek() != -1){
                    temp += stack.pop();
                }
                if(stack.isEmpty()) return 0;
                stack.pop();
                cnt1--;
                temp = temp == 0 ? 1 : temp;
                stack.add(temp * 2);
            }else {
                int temp = 0;
                if(cnt2 == 0) return 0;
                while(!stack.isEmpty() && stack.peek() != -2){
                    temp += stack.pop();
                }
                if(stack.isEmpty()) return 0;
                stack.pop();
                cnt2--;
                temp = temp == 0 ? 1 : temp;
                stack.add(temp * 3);
            }
        }

        if(cnt1 > 0 || cnt2 > 0) return 0;
        for(int a : stack)
            result += a;
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        System.out.println(getStack(str));
    }
}
