package DataStructure.Stack;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//32(5)
//33(562(71(9)))
public class 압축_1662 {

    private static String initString;
    private static HashMap<Integer,Integer> pair;
    private static int recur(int start, int end) {

        int cnt = 0;

        for(int i = start; i < end ; i++){
            if(initString.charAt(i) == '('){
                //몇번 곱하는지
                int multi = initString.charAt(i - 1) - '0';
                // i + 1부터
                cnt += multi * recur(i + 1, pair.get(i));
                i = pair.get(i);
            }else {
                // ( 가 아닐 경우 하나씩 전진
                if(i + 1 < end && initString.charAt(i + 1) == '(')
                    continue;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        initString = input.readLine();

        //초기 괄호 쌍 선언
        pair = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < initString.length(); i++){
            int ch = initString.charAt(i);
            if(ch == '(')
                stack.add(i);

            if(ch == ')')
                pair.put(stack.pop(),i);
        }
        //문자열을 () 기준으로 점점 좁혀들어가기
        System.out.println(recur(0,initString.length()));
    }
}
