package 이것이코딩테스트다_BOOK.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//각 행에서 최소값을 찾고 그 최소값중에서 가장 큰수를 고르는 문제
public class 숫자카드게임 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int arr[][]=new int[n+1][m+1];
        int max=-1;
        for(int i=1;i<=n;i++){
            arr[i][0]=10000000;
            st=new StringTokenizer(input.readLine());
            for(int j=1;j<=n;j++){
                arr[i][j]=Integer.parseInt(st.nextToken());
                arr[i][0]=Math.min(arr[i][0],arr[i][j]);
            }
            max=Math.max(max,arr[i][0]);
        }
        System.out.println(max);
    }
}
