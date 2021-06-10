package DataStructure.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/*
매일
주식을 산다.
원하는 만큼 가지고 있는 주식을 산다.
아무것도 안한다.
 */
/*
3
3
10 7 6
3
3 5 9
5
1 1 3 1 2
 */
public class 주식_11501 {



    private static long getSum(int[] arr, int n) {
        long sum = 0;
        int index = n - 1;
        for(int j = n - 1; j >= 0; j--){

            if(arr[index] < arr[j]){
                index = j;
            }else{
                sum += arr[index] - arr[j];
            }
        }
        return sum;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int k = Integer.parseInt(input.readLine());
        for(int i = 0; i < k; i++) {
            int n = Integer.parseInt(input.readLine());
            int arr[] = new int[n];

            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++)
                arr[j] = Integer.parseInt(st.nextToken());

            sb.append(getSum(arr,n)).append("\n");
        }

        System.out.println(sb);
    }
}
