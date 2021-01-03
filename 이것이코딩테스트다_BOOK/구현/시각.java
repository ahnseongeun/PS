package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 정수 N이 입력되면 00시 00분 00초 부터 N시 59분 59초까지의 3이 하나라도 포함되는 수의 개수 구하는 문제
 * String을 이용해서 해결하면 쉽게 해결할수 있다.
 */
public class 시각 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int targetTime= Integer.parseInt(input.readLine());
        int count=0;
        for(int i=0;i<=targetTime;i++){
            for(int j=0;j<60;j++){
                for(int k=0;k<60;k++){
                    String time= i +String.valueOf(j)+ k;
                    if(time.contains("3")) count++;
                }
            }
        }
        System.out.println(count);
    }
}
