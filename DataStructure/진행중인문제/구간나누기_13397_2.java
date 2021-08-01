package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 한문제로 이 문제를 정의하면 원소의 최대 범위인 10000부터 0까지 숫자중에서 해당 숫자를 만족하는 구간의 개수가 m보다 작거나 같을 때 출력
 */
/*
8 3
1 5 4 6 2 1 3 7
 */
public class 구간나누기_13397_2 {

    static int n;
    static int[] arr;

    private static boolean isCheck(int mid, int target) {

        int max = -1;
        int min = 10001;
        int cnt = 0;

        for( int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
            if( max - min > mid) {
                cnt += 1;
                if(cnt >= target) return false;
                max = arr[i];
                min = arr[i];
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        st = new StringTokenizer(input.readLine());
        for( int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 10000;
        int min = 10001;

        while(start <= end) {

            int mid = ( start + end ) / 2;

            // 아래 isCheck를 만족하면 구간의 수가 m보다 작은 것이다. mid 값을 줄여서 구간이 많이 나오게 해야한다.
            if (isCheck(mid, m)) {
                //mid 값이 클 수록 구간이 적게 나온다. -> 구간의 수가 m보다 작으면서 mid가 작게해야 한다.
                //mid 값이 작을 수록 구간이 많이 나온다.
                min = Math.min(min, mid);
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(min);
    }
}
