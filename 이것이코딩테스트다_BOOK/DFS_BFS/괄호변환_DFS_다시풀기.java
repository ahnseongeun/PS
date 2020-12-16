package 이것이코딩테스트다_BOOK.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

//요구된 조건에 맞게 그대로 풀면되는 문제 문제를 잘읽어야 하는 문제
public class 괄호변환_DFS_다시풀기 {
    public static String total(String str){
        if(str.equals(""))
            return "";

        int idx=division(str);
        String u=str.substring(0,idx);
        String v=str.substring(idx,str.length());
        if(correct(u)){
            u+= total(v);;
            return u;
        }else{
            String temp="(";
            temp+=total(v);
            temp+=')';
            u=u.substring(1,u.length()-1);
            u=dfs(u);
            return temp+u;
        }
    }
    public static int division(String u){
        int idx=0;
        int size=u.length();
        int left_count=0;
        int right_count=0;
        while(true){
            if(idx==size)
                break;
            char ch= u.charAt(idx++);
            if(ch=='('){
                left_count++;
            }else{
                right_count++;
            }
            if(left_count==right_count)
                break;
        }
        return idx;
    }
    public static boolean correct(String u){
        boolean check=true;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<u.length();i++){
            char ch=u.charAt(i);
            if(ch=='('){
                st.push(ch);
            }else{
                if(st.isEmpty()){
                    check=false;
                    break;
                }else {
                    st.pop();
                }
            }
        }

        return check;
    }
    public static String dfs(String u){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<u.length();i++){
            char ch= u.charAt(i);
            if(ch=='('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        }
        String result=sb.toString();
        return result;
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str=input.readLine();
        String result="";
        result=total(str);
        System.out.println(result);
    }
}
