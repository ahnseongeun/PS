package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
/*
 *** Java의 경우, Integer 객체끼리의 비교를 == 또는 != 으로 하는 경우가 종종 보이는데,
 * 이는 두 객체의 주소값이 같은지를 보는 것으로 절대로 해서는 안 되는 연산입니다.
 * Java에서 미리 만들어 둔 객체들 범위인 127을 넘어가는 순간 더 이상 원하는 대로 동작하지 않습니다. intValue() 를 꼭 써서 비교하시기 바랍니다.
 */
public class 백준_1874_스택수열 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        int n=Integer.parseInt(input.readLine());
        int target_arr[]=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            target_arr[i] = Integer.parseInt(input.readLine());
        }
        int start=1;
        int target_index=0;
        while(true) {
            if (start==n+1) {
                break;
            }
            if (target_arr[target_index] == start) {
                st.push(start++);
                sb.append("+"+"\n");
                while (!st.empty()&& st.peek().intValue() == target_arr[target_index]) {
                    st.pop();
                    sb.append("-"+"\n");
                    target_index++;
                }
            } else {
                st.push(start);
                sb.append("+"+"\n");
                start++;
            }
        }
        if(st.empty())
            System.out.println(sb);
        else
            System.out.println("NO");


    }
}
