package 이것이코딩테스트다_BOOK.그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
3 2 1 1 9
 */
public class 만들수없는금액_그리디_다시풀기 {
    static boolean result[]=new boolean[1000001];
    static void bfs(int arr[],int idx,int sum){
        if(idx==arr.length){
            return;
        }
        for(int i=idx;i<arr.length;i++){
            sum+=arr[i];
            result[sum]=true;
            bfs(arr,i+1,sum);
            sum-=arr[i];
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        StringTokenizer st=new StringTokenizer(input.readLine());
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        //1번방식
        bfs(arr,0,0);
        int total=0;
        for(int i=1;i<result.length;i++)
            if(!result[i]) {
                total = i;
                break;
            }
        System.out.println(total);

        /*
        2번 방식은
        그리디를 이용하는 방식이다.
        거스름 돈과 다르게 한정된 동전일 때 가능하다.
        응용을 하면 배열이 주어졌을 때 만들수 없는 조합의 가장 최소 값을 알수 있다.
         */
        int target=1;
        Arrays.sort(arr);
        for(int i=0;i< arr.length;i++){
            if(arr[i]>target){
                break;
            }else{
                target+=arr[i];
            }
        }
        System.out.println(target);
    }

}
