package 이것이코딩테스트다_BOOK.정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//힌트 정렬 문제
//왜 정렬을 사용할까??
//반드시 중간값만 선택하면 최소가 되는것인가?
//-> 중간값을 비교해보자 그 근처의 값을 비교해보자 -> 중간값에서 멀어질수도 값이 증가하는 것을 볼수 있다.
public class 안테나 {
    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        StringTokenizer st=new StringTokenizer(input.readLine());
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());
        Arrays.sort(arr);
        System.out.println(n%2==0?arr[n/2-1]:arr[n/2]);
    }
}
