package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 문자열재정렬 {
    public static void main(String[] args) throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        char ch[]= input.readLine().toCharArray();
        Arrays.sort(ch);
        int idx=0;
        int sum=0;
        for(int i=0;i<ch.length;i++){
            int tempCh=ch[i]-'0';
            if(tempCh<=9){
                sum+=tempCh;
                idx++;
            }else{
                break;
            }
        }
        /**
         * char형 배열을 String으로 변환하는 간단한 방법.
         */
        String str= new StringBuilder(new String(ch)).substring(idx)+sum;
        System.out.println(str);
    }
}
