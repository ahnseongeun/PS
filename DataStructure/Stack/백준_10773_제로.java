package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 백준_10773_제로 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        Stack<Integer> st=new Stack<>();
        int sum=0;
        int n= Integer.parseInt(input.readLine());
        for(int i=0;i<n;i++){
            int present_value=Integer.parseInt(input.readLine());
            if(present_value!=0){
                st.push(present_value);
            }else{
                st.pop();
            }
        }
        for(Integer val:st)
            sum+=val.intValue();
        System.out.println(sum);
    }
}
