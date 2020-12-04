package DataStructure.String;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 백준_10988_팰린드롬_for문 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str= input.readLine();
        int size=str.length();
        int result=1;
        for(int i=0;i<size/2+1;i++){
            if(str.charAt(i)!=str.charAt(size-1-i)){
                result=0;
                break;
            }
        }
        System.out.println(result);
    }
}
