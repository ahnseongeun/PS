package 이것이코딩테스트다_BOOK.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1.
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

2.
10
1 1
1 2
1 3
1 4
1 5
1 6
1 7
1 8
1 9
1 10
 */
public class 퇴사_DP {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n= Integer.parseInt(input.readLine());
        StringTokenizer st;
        int arr[][]=new int[n+2][2];
        int dp[]=new int[n+2];
        int max=0;

        for(int i=1;i<=n;i++){
            st= new StringTokenizer(input.readLine());
            int t=Integer.parseInt(st.nextToken());
            int p=Integer.parseInt(st.nextToken());
            arr[i][0]=t; //시간
            arr[i][1]=p; //가격
        }

        for(int i=1;i<=n+1;i++){ //n+1까지 포함하는 이유는 마지막날 다음까지 체크
            int idx=i+arr[i][0];
            if(idx>n+1) //퇴사 이후에 끝이나면 통과
                continue;
            dp[idx]=Math.max(dp[idx],dp[i]+arr[i][1]); //기존값과 추가 했을 경우 비교해서 큰 값 삽입
            for(int j=idx;j<=n+1;j++){
                dp[j]=Math.max(dp[idx],dp[j]); //현재 인덱스 보다 큰 인덱스와 비교해서 작은경우 채우기
            }
            max=Math.max(dp[idx],max); //최대값 비교
        }
        //display(dp);
        System.out.println(max);
    }

    private static void display(int[] dp) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<dp.length;i++){
            sb.append(dp[i]+" ");
        }
        System.out.println(sb);
    }
}
