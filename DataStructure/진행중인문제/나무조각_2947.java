package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 나무조각_2947 {

    private static boolean check(int[] arr) {
        for(int i = 1; i <= 5; i++){
            if(arr[i - 1] != i)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        int arr[] = new int[st.countTokens()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        while(check(arr)){
            for(int i = 0; i < 4; i++){
                if(arr[i] > arr[i + 1]){
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                    for(int j = 0; j < 5; j++)
                        sb.append(arr[j] + " ");
                    sb.append("\n");
                }
            }
        }
        System.out.println(sb);
    }


}
