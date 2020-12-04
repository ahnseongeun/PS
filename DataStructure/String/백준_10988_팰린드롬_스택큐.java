package DataStructure.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 백준_10988_팰린드롬_스택큐 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str= input.readLine();
        int result=1;
        Stack<Character> st=new Stack<>();
        Queue<Character> q=new LinkedList<>();
        for(int i=0;i<str.length();i++){
            st.push(str.charAt(i));
            q.add(str.charAt(i));
        }
        for(int i=0;i<str.length()/2+1;i++){
            if(st.pop()!=q.poll()){
                result=0;
                break;
            }
        }
        System.out.println(result);
    }
}
