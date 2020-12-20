package 이것이코딩테스트다_BOOK.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * input 1<= N <= 1000, 1 <= M <= 10, 1<= K <= M
 * output 두사람이 볼링공을 고르는 경우의 수
 * 서로 무게가 다른 볼링공을 고른다. 순서쌍을 구할때 같은 무게는 제외
 * 1. 수학적인 접근
 * 2. 프로그래밍 적 접근
 */
public class 볼링공고르기_그리디 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int weights[]=new int[m+1];

        st=new StringTokenizer(input.readLine());
        for(int i=0;i<n;i++){
            int weight=Integer.parseInt(st.nextToken());
            weights[weight]++;
        }
        int totalNumber=n*(n-1)/2;
        for(int i=1;i<=m;i++){
            int temp=weights[i];
            if(temp>=2){
                totalNumber-=(temp*(temp-1)/2);
            }
        }
        System.out.println(totalNumber);
    }
}
