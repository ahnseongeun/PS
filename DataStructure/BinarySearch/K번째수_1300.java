package DataStructure.BinarySearch;

/*
3
7
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 이 문제는 n이 500000이기 때문에 i, j를 이용해서 2차원 배열로 저장 후 sort로 풀수 없다.
 * 그러면 어떻게 접근해야 할 까? 최대 범위가 1000000000이기 때문에 이 값에서 이분 탐색을 통해서 조건에 맞는 인덱스를 찾는다.
 * 고민해야 될 것이 end의 범위는 어디인가?
 *  -> arr[k]의 값은 항상 k보다 작다 -> 즉, end의 범위는 k가 된다.
 * 어떻게 해당 값의 인덱스를 찾을 수 있는가?
 *  -> min(n, k / i(행) )
 *  결과는 B[k] 출력
 */
public class K번째수_1300 {
    private static int getIndex(int n, int mid) {

        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += Math.min((mid / i), n);
        }

        return sum;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int k = Integer.parseInt(input.readLine());

        int start = 1;
        int end = k;
        int result = 0;
        while(start <= end) {

            //중앙 값을 찾는다.
            int mid = (start + end) / 2;

            //min(n,  k / for(i < n) -> 현재 mid의 index값을 찾는다.
            int index = getIndex(n, mid);

            //System.out.println(mid + " " + index);
            // index가 k보다 더 크다면 mid를 줄여야지
            // low_bound 형식이다. 왜냐하면 조건을 만족하는 index중에서 가장 작은 값을 찾아야 하니깐
            if( k <= index) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(result);
    }
}
