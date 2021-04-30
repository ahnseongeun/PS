package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1
13
8
 */
public class 조약돌꺼내기_13251 {

    private static double getTotal(int arr[], int k) {
        int sum = 0;
        int size = arr.length;
        for(int i = 0; i < size; i++ )
            sum += arr[i];

        double p = 1.0;
        //분모 구하기
        for(int i = 1; i <= k; i++){
            p *= i;
        }

        //분자 구하기
        double n = 1.0;
        for(int i = sum; i > sum - k; i--){
            n *= i;
        }
        return (double)n / p;
    }

    private static double getSum(int value, double total, int k) {
        //분모 구하기
        double n = 1.0;
        for(int i = value; i > value - k ; i--){
            n *= i;
        }

        double p = 1.0;
        for(int i = 1; i <= k ; i++){
            p *= i;
        }
        return (((double)n / p) / total);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(input.readLine());
        int[] arr = new int[m];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < m ; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(input.readLine());

        //분모 구하기
        double total = getTotal(arr , k);
        double sum = 0;
        for(int i = 0; i < m; i++){
            sum += getSum(arr[i] , total, k);
        }
        System.out.print(sum);
    }
}
