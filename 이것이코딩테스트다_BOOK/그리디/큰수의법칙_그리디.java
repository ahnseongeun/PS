package 이것이코딩테스트다_BOOK.그리디;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
N - 몇개의 수인지
M - 몇번 더 할것인지
K - 연속해서 몇번까지 더 할수 있는지
5 8 3
2 4 5 4 6
46
*/
public class 큰수의법칙_그리디 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[]=new int[n];
        int sum=0;
        st= new StringTokenizer(input.readLine());
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        //내가 푼 방식
        int count=0;
        int cnt=0;
        int idx=n-1;
        while(true){
            if(count==m)
                break;
            if(cnt==k){
                cnt=0;
                sum+=arr[idx-1];
                count++;
                cnt++;
            }else {
                sum+=arr[idx];
                count++;
                cnt++;
            }
        }

        /*
        동빈님의 풀이
        가장 큰수를 몇번 더할지 계산한다.
        전체에서 계산한 수를 뺀 수만큼 두번째 큰수를 더한다.
        int first=arr[n-1];
        int second=arr[n-2];
        int first_count=((m/(k+1))*k+m%(k+1)); //+1을 해주는 이유는 second를 포함해서 first의 count를 구할수 있다.
        int second_count=m-first_count;
        sum+=(first*first_count+second*second_count);
         */
        System.out.println(sum);
    }
}
