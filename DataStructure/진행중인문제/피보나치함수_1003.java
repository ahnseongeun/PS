package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 피보나치함수_1003 {
    static int arr[][];
    private static void fibonacci(int num) {
        for(int i = 2;i <= num; i++){
            arr[i][0] = arr[i-1][0] + arr[i-2][0];
            arr[i][1] = arr[i-1][1] + arr[i-2][1];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0;i < n; i++){
            int num = Integer.parseInt(input.readLine());
            arr = new int[41][2];
            arr[0][0] = 1;
            arr[0][1] = 0;
            arr[1][0] = 0;
            arr[1][1] = 1;
            fibonacci(num);
            sb.append(arr[num][0]+" "+arr[num][1]+"\n");
        }
        System.out.println(sb);
    }
}
