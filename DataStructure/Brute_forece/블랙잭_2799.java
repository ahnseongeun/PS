package DataStructure.Brute_forece;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 21
5 6 7 8 9
 */
public class 블랙잭_2799 {
    public static void main(String[] args) throws  Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=Integer.parseInt(st.nextToken());

        int sum=0;
        int max=-1;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
                for(int k=j+1;k<n;k++) {
                    sum = arr[i] + arr[j] + arr[k];
                    if(m>=sum&&max<sum)
                        max=sum;
                }
        }
        System.out.println(max);
    }
}
