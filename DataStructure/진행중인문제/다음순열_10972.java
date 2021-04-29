package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3
1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
 */

/**
 * 다음 순열을 구하는 방법은?
 * 1. 오른쪽에서 부터 arr[i - 1] < arr[i] 인 것 i 체크
 * 2. i를 기준으로 배열을 나누고 오른쪽 배열의 마지막 수와 왼쪽 배열 가장 마지막 부터 탐색하면서 더 작은수 가 있다면
 *    SWAP 한다.
 * 3. 우측을 정렬 한다.
 *
 * 1 2 3 4
 * 1 2 4 3
 * 1 3 2 4
 * 1 3 4 2
 */
public class 다음순열_10972 {

    private static int n;
    private static StringBuilder sb = new StringBuilder();

    private static boolean next_permutation(int[] arr) {
        int idx = arr.length - 1;

        // 오른쪽에서 부터 arr[i - 1] < arr[i] 인 것 i 체크
        for(int i = idx; i >= 0 ; i--){
            if(i == 0)
                return true;
            if(arr[i - 1] < arr[i]){
                idx = i;
                break;
            }
        }

        //i를 기준으로 배열을 나누고 오른쪽 배열의 마지막 수와 왼쪽 배열 가장 마지막 부터 탐색하면서 더 작은수 가 있다면
        for(int i = arr.length - 1; i >= idx ; i--){
            if(arr[idx - 1] < arr[i]){
                element_swap(arr, idx - 1, i);
                break;
            }
        }
        Arrays.sort(arr,idx,arr.length);

        return false;

    }

    private static void element_swap(int[] arr, int j, int i) {
        int tmp = arr[j];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        if(next_permutation(arr)){
            System.out.println(-1);
        }else{
            Arrays.stream(arr).forEach(value -> sb.append(value + " "));
            System.out.println(sb);
        }

    }
}
