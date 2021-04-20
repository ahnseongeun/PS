package DataStructure.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1 2 2 7
public class 부분수열의합_14225 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        //(bfs)


        //(그리디)가장 작은수로 초기화
        int result = 1;

        for(int i = 0; i < arr.length; i++){
            if(result < arr[i])
                break;
            result += arr[i];
        }
        System.out.println(result);
    }
}
