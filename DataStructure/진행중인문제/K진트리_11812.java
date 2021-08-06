package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
7 2 3
1 2
2 1
4 7
 */

/**
 * 어떻게 부모 노드를 찾을지 정하는 알고리즘을 구하면 쉽게 풀 수 있는 문제
 * LCA 알고리즘 -> 부모 노드를 구하는 공식 N P = (N - 2) / k + 1
 */
public class K진트리_11812 {

    static long n;
    static int k;

    /**
     * 기존의 나는 start의 모든 노드를 기록하고 end의 자식노드를 찾아가면서 start노드를 만족하는 것이 있는지 찾았다.
     * 하지만 더 좋은 방법은 현재 start와 end를 비교하면서 더 큰 값의 부모노드를 찾는 방법으로 한다...
     * @param left
     * @param right
     * @return
     */
    static int getDistance(long left, long right) {

        int cnt = 0;
        while(left != right) {
            if(left > right ) {
                left = ( left - 2 ) / k + 1;
            } else {
                right = ( right - 2 ) / k + 1;
            }
            cnt++;
        }
        return cnt;
    }


    public static void main( String[] args ) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Long.parseLong(st.nextToken()); //노드의 개수
        k = Integer.parseInt(st.nextToken()); //한 노드당 자식의 수
        int testCase = Integer.parseInt(st.nextToken()); // 총 몇개의 TestCase가 있는지

        for(int i = 0; i < testCase; i++) {
            st = new StringTokenizer(input.readLine());
            long start = Long.parseLong(st.nextToken());
            long end = Long.parseLong(st.nextToken());
            if(k == 1) sb.append(Math.abs(start - end)).append("\n");
            else sb.append(getDistance(start, end)).append("\n");
        }

        System.out.println(sb);
    }
}
