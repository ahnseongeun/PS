package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
1, 2, 3
1, 3, 2
2, 1, 3
2, 3, 1
3, 1, 2
3, 2, 1
 */

/**
 * 이전 순열을 구하는 방법
 *  기본적으로 오름 차순을 만드는 것이 핵심이다.
 *  즉, 내림 차순을 오름 차순으로 바꾸는 것이 핵심
 *  1. arr[i - 1] > arr[i] 먼저 내림 차순을 찾는다.
 *  2. i - 1 < i ~ 배열의 길이의 원소를 찾는다.
 *  3. swap한다.
 *  4. 내림 차순으로 정렬한다.
 */
public class 이전순열_10973 {

    private static boolean pre_permutation(int arr[]) {

         int idx = arr.length - 1;
         for(int i = idx; i >= 0 ; i--){
             if(i == 0)
                 return true;
             if(arr[i - 1] > arr[i]){
                 idx = i;
                 break;
             }
         }

         for(int i = arr.length - 1 ; i >= idx; i--){
             if(arr[idx - 1] > arr[i]){
                 element_swap(arr,idx - 1,i);
                 break;
             }
         }
        //역순 뒤집기
        reverse(arr,idx,arr.length - 1);
         return false;
    }


    private static void reverse(int[] arr, int idx, int length) {
        int start = idx;
        int end = length;
        for(int i = 0; i <= (length - idx) / 2; i++){
            element_swap(arr,start++,end--);
        }
    }

    private static void element_swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        int arr[] = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        if(pre_permutation(arr)){
            System.out.println(-1);
        }else{
            Arrays.stream(arr).forEach(value -> sb.append(value + " "));
            System.out.println(sb);
        }
    }
}
