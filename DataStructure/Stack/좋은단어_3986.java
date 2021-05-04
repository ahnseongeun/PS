package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

/*
3
ABAB
AABB
ABBA
 */
public class 좋은단어_3986 {

    private static int checkGoodWord(String str) {
        Stack<Character> stack = new Stack<>();
        stack.add(str.charAt(0));

        for(int i = 1; i < str.length(); i++){

            if(!stack.isEmpty() && stack.peek() == str.charAt(i))
                stack.pop();
            else
                stack.add(str.charAt(i));
        }
        return stack.isEmpty() ? 1 : 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int result = 0;
        for(int i = 0; i < n; i++){
            String str = input.readLine();
            result += checkGoodWord(str);
        }
        System.out.println(result);
    }
}
