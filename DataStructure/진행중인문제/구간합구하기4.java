package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5 3
5 4 3 2 1
1 3
2 4
5 5
이 문제는 구간합이 주어질 때마다 합을 구하는 문제가 아니다.
모든 합산을 구한 배열을 하나 만들고 구간의 차이를 구해서 차이를 구한다.
 */
public class 구간합구하기4 {

    private static int subSum(int start, int end, int[] arr) {
        return arr[end] - arr[start - 1];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(input.readLine());
        int arr[] = new int[n + 1];
        for(int i = 1 ; i <= n; i++)
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());

        for(int i = 0 ; i < m ; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(subSum(start,end, arr)+"\n");
        }
        System.out.println(sb);
    }
}
