package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
4 40 50 10
10 20 30 25
 */

/**
 * 어떻게 하면 완전탐색을 빠르게 할 수 있을까??
 * N이 15이 기 때문에 최대 2^15개
 * 포함하고 안 포함하고 수열의 모든 경우를 구하는 것은 재귀를 이용하면 편하다.
 */
public class 캠프준비_16938 {

    private static int n, l, r, x;
    private static int arr[];

    /**
     * 변수 설명
     * @param idx 현재 인덱스의 위치
     * @param sum 현재까지의 합
     * @param cnt 현재 몇개의 인덱스를 선택했는지
     * @param start 최저값
     * @param end 최고 값
     * @return
     */
    private static int getProblemCount(int idx, int sum, int cnt,int start, int end) {
        int result = 0;

        if(idx == n){
            if(cnt >= 2 && l <= sum && sum <= r && end - start >= x){
                return 1;
            }
            return 0;
        }

        result += getProblemCount(idx + 1, sum + arr[idx], cnt + 1, Math.min(start,arr[idx]),Math.max(end,arr[idx]));
        result += getProblemCount(idx + 1, sum, cnt, start, end);

        return  result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        n = Integer.parseInt(st.nextToken()); //총 몇개의 문제인지
        l = Integer.parseInt(st.nextToken()); //난이도 합의 최소 값
        r = Integer.parseInt(st.nextToken()); //난이도 합의 최대 값
        x = Integer.parseInt(st.nextToken()); // 가장 어려운 난이도 - 가장 쉬운 난이도

        arr = new int[n];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < n ; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        //Arrays.sort(arr);
        int result = 0;
        result = getProblemCount(0, 0,0,2000000000,0);
        System.out.println(result);
    }
}
