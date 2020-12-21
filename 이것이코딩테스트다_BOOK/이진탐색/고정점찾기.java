package 이것이코딩테스트다_BOOK.이진탐색;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//N 1000000
public class 고정점찾기 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        StringTokenizer st=new StringTokenizer(input.readLine());
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        int start=0;
        int end=arr.length-1;
        int result=-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]<mid){
                start = mid + 1;
            }else if(arr[mid]>mid){
                end = mid - 1;
            }else{
                result=mid;
                break;
            }
        }
        System.out.println(result);
    }
}
