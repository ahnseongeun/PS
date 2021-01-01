package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 해당 인덱스에서 최소가 되는 값을 저장 하도록 계획 해야한다.
 * 가장 최대가 되는 경우는 +1이다.
 * 두번째로 최대가 되는 경우는 *2이다.
 * 세번째로 최대가 되는 경우는 *3이다.
 * 네번째로 최대가 되는 경우는 *5이다.
 * 10을 기준으로 보면
 * +1을 이용하면 9번의 연산
 * +1과 *2를 이용하면 5번의 연산
 * +1과 *2와 *3을 이용하면 3번의 연산
 * 1과 *2와 *3 *5을 이용하면 2번의 연산
 * 최대를 구하고 최소가 되는 조건과 비교해서 만족하면 최소의 값을 해당 인덱스에 저장한다.
 */
public class 일로만들기_DP {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int target=Integer.parseInt(input.readLine());
        int dp[]=new int[target+1];
        for(int i=2;i<=target;i++){
            dp[i]= dp[i-1]+1;
            if(i%2==0)
                dp[i]= Math.min(dp[i],dp[i/2]+1);
            if(i%3==0)
                dp[i]= Math.min(dp[i],dp[i/3]+1);
            if(i%5==0)
                dp[i]= Math.min(dp[i],dp[i/5]+1); //5나누기
            //System.out.println(i+" "+dp[i]);
        }
        System.out.println(dp[target]);
    }
}
