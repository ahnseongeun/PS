package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class 럭키스트레이트 {
    public static void main(String[] args) throws Exception{
        BufferedReader input= new BufferedReader(new InputStreamReader(System.in));
        char ch[]=input.readLine().toCharArray();
        int n= ch.length;
        int sum1=0;
        int sum2=0;
        for(int i=0, j=n/2;i<n/2;i++,j++){
            sum1+=ch[i];
            sum2+=ch[j];
        }
        if(sum1==sum2){
            System.out.println("LUCKY");
        }else{
            System.out.println("READY");
        }
    }
}
