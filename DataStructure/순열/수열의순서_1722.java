package DataStructure.순열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 1. 작은수 부터 때려 박으면된다.
 * 2. (i - 1) * (n - 1)! + 순열돌리기?
 */
/*
4
1 3
4
2 1 3 2 4
3
2 3 2 1
3
2 1 2 3
 */
public class 수열의순서_1722 {
    private static StringBuilder sb = new StringBuilder();
    private static long factorial[];
    private static boolean visited[];

    private static long getOrder(int n, int[] arr) {
        long sum = 0;

//        sum += (Math.max(arr[i - 1] - list.get(0), 0)) * factorial[n - 1];
//        list.remove((Integer) arr[i - 1]);
//        n--;
        //순서를 구하는 함수
        //2 3 1일 경우
        for(int i = 0; i < n; i++){
              for(int j = 1; j <= n; j++){
                  if(visited[j])
                      continue;
                  if(arr[i] > j){
                      sum += factorial[n - 1 - i];
                  }else{
                      visited[arr[i]] = true;
                  }
              }
        }
        return sum + 1;
    }



    private static void getPermutation(int n, long order) {

        //arr 탐색
        for(int i = 0; i < n; i++){
            //허용 가능한 숫자 탐색
            for(int j = 1; j <= n; j++ ){
                if(visited[j])
                    continue;

                if(order > factorial[n - 1 - i]){
                    order -= factorial[n - 1 - i];
                }else{
                    sb.append(j + " ");
                    visited[j] = true;
                    break;
                }

            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        factorial = new long[21];
        visited = new boolean[21];
        factorial[0] = 1;
        for(int i = 1; i <= 20; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        int select = Integer.parseInt(st.nextToken());


        //순서 -> 순열
        if(select == 1){
            long order = Long.parseLong(st.nextToken());
            getPermutation(n,order);
        //수열 -> 순서
        }else{
            int[] arr = new int[n];
            for(int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());
            System.out.println(getOrder(n, arr));
        }
    }
}
