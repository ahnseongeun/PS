package DataStructure.BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 연산 과정중에 int형 범위를 넘어가는 것이 있어서 long으로 배열을 만들어주는 것을 생각 못해서 많이 틀렸다.
 */
public class 나무자르기_2805번 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        long[] wood = new long[n];

        for(int i = 0; i < n; i++)
            wood[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(wood);

        long max_height = -1;
        long left = 0;
        long right = wood[n-1];
        while(left <= right){
            long sum = 0;
            long mid = (left + right) / 2;

            sum += Arrays.stream(wood)
                    .filter(value -> value - mid >= 0)
                    .map(operand -> operand - mid ).sum();
            if(sum >= m){ //목표치 보다 자른 값이 많다면 더 높게 설정
                if(sum == m){
                    max_height = mid;
                    break;
                }
                max_height = Math.max(max_height,mid);
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(max_height);

    }
}
