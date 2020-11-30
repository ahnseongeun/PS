package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_9012_괄호 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(input.readLine());
        for(int i=0;i<n;i++){
            Stack<Character> st=new Stack<>();
            String str=input.readLine();
            Boolean flag=true;
            for(int j=0;j<str.length();j++){
                if(str.charAt(j)=='('){
                    st.push('(');
                }else{
                    if(st.empty()){ //스택에 '('가 없을때 ')'가 들어온 경우 검사
                        flag=false;
                        break;
                    }else{
                        st.pop();
                    }

                }
            }
            if(flag&&st.empty()){ //스택에 '('가 들어있을때를 검사
                sb.append("YES\n");
            }else{
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
