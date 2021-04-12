package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 압축_1662 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        //입력 받은 문자열
        String str = input.readLine();
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        Stack<Character> st = new Stack<>();
        Stack<Character> operator = new Stack<>();
        int cnt = 0;
        for(int i = 0; i < len; i++){

            char ch = str.charAt(i);

            if(ch >= '0' && ch <= '9'){
                st.push(ch);
            }else if(ch == '('){
                //(를 만나게 되면 숫자를 빼서 operator로 이전
                operator.push(st.pop());
                cnt++;
            }else{ //ch == ')'
            }
        }

    }
}
