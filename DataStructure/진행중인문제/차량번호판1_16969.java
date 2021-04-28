package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 차량번호판1_16969 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();
        int d_count = 10;
        int c_count = 26;
        int sum = 1;
        for(int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if(ch == 'd'){
                c_count = 26;
                sum *= d_count == 9 ? d_count: d_count--;
            }
            if(ch == 'c'){
                d_count = 10;
                sum *= c_count == 25 ? c_count: c_count--;
            }
        }
        System.out.println(sum);
    }
}
