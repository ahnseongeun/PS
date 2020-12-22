package 이것이코딩테스트다_BOOK.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 공유기설치_다시풀기 {

    private static int CountWifi(int[] arr, int mid) {
        int start=arr[0];
        int count=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]-start>=mid){
                count++;
                start=arr[i];
            }
        }
        return count;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken()); //공유기 개수

        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(input.readLine());
        Arrays.sort(arr);

        int min=1;
        int max=arr[arr.length-1]-arr[0];
        int count=0;
        int result=max;
        while(min<=max){
            int mid=(min+max)/2;
            count=CountWifi(arr,mid);
//            System.out.println("count"+count+" mid"+mid);
//            System.out.println("min"+min+" "+"max"+max);
            if(count>m){
                min=mid+1;
                result=mid;
            }else if(count<m){
                max=mid-1;
            }else{
                min=mid+1;
                result=mid;
            }
        }
        System.out.println(result);
    }
}
