package DataStructure.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 위상정렬은 순서가 정해져 있는 작업을 차례대로 수행해야 할 때 그 순서를 결정하는 알고리즘
 * 위상정렬의 조건은 싸이클이 존재하지 않는 방향 그래프이다. (DAG - direct Acyclic Graph)
 * 즉, 시작점이 존재해야한다.
 */
public class ACM_CRAFT_1005 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(input.readLine());
        for(int i = 0; i < num; i++){
            int total = 0;
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] time = new int[n + 1];
            boolean[][] path = new boolean[n + 1][n + 1];
            st = new StringTokenizer(input.readLine());
            for(int j = 1; j <= n; j++) time[j] = Integer.parseInt(st.nextToken());
            for(int j = 1; j <= m; j++){
                st = new StringTokenizer(input.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                path[start][end] = true;
            }
            total += time[1];
            for(int j = 1; j <= m; j++){
                int max = -1;
                for(int k = j + 1; k <= m; k++ ){
                    if(path[j][k]) {
                        path[j][k] = false;
                        max = Math.max(max, time[k]);
                    }
                }
                total += max;
            }
            System.out.println(total);
        }
    }
}
