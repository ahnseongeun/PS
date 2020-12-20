package 이것이코딩테스트다_BOOK.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 곱하기혹은더하기_그리디 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String str=input.readLine();
        char[] chars=str.toCharArray();
        int sum=1;

        for(int i=0;i<str.length();i++){
            if(chars[i]=='0'){
                sum+=(chars[i]-'0');
            }else{
                sum*=(chars[i]-'0');
            }
        }
        System.out.println(sum);
    }
}
