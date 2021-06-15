package DataStructure.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
7
3 1 6 2 7 30 1
1 1 2 3 6 7 30
2 3 5 8 14 21 51
 */
/**
 *
 */
public class 저울_2437 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int target = 1;
        //현재 target이 arr[index]보다 작다면 만들수 없는 수.
        //target이 arr[index]보다 크거나 같다면 target에 arr[index]를 더해주기
        /**
         * 가장 큰 핵심은 target보다 arr[i]가 큰 경우 죽어도 target을 만들 수 없다.
         */
        for(int i = 0; i < arr.length; i++) {
            if (target < arr[i]) break;
            target += arr[i];
        }
        System.out.println(target);
    }
}
