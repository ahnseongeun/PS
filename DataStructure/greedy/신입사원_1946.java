package DataStructure.greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

/*
2
5
3 2
1 4
4 1
2 3
5 5
7
3 6
7 3
4 2
1 4
5 7
2 5
6 1
 */
/*
1. 정렬
2. 큐에 넣기
3. 제거하면서 CNT++;
flag = false 라면 break;
cnt 출력
 */
public class 신입사원_1946 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(input.readLine());
        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(input.readLine());
            int[] arr = new int[n + 1];
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(input.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arr[a] = b;
            }

            int max = arr[1];
            int cnt = 1;
            for(int j = 2; j <= n; j++) {
                int value = arr[j];
                if(max > value) {
                    max = value;
                    cnt++;
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
