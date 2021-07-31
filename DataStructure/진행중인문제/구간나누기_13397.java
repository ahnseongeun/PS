package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
8 3
1 5 4 6 2 1 3 7
8 4
1 2 3 4 5 6 7 8
 */
public class 구간나누기_13397 {

    static int n;
    static int m;
    static boolean getIntervalCount(int mid, int[] arr) {

        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        int intervalCnt = 0;

        for(int i = 0; i < n; i++) {
            if(minVal > arr[i]) minVal = arr[i];
            if(maxVal < arr[i]) maxVal = arr[i];

            if(maxVal - minVal > mid) {
                intervalCnt++;
                minVal = arr[i];
                maxVal = arr[i];
                if(intervalCnt > m) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 10000;
        //end를 감소시키는 것은 더 많은 구간, start를 증가시키는 것은 더 적은 구간

        while(start <= end) {

            int mid = ( start + end ) / 2;
            //현재 mid를 만족시킬 때 구간이 몇개인지
            if( getIntervalCount(mid, arr)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
