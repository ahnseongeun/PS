package DataStructure.Stack;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class 제로_10773 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n ; i++){
            int num = Integer.parseInt(input.readLine());
            if(num == 0 && !st.isEmpty()) {
                st.pop();
            }else {
                st.push(num);
            }
        }
        int sum = st.stream().mapToInt(value -> value).sum();
        System.out.println(sum);
    }
}
