package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
4 5
50 45 37 32 30
35 50 40 20 25
30 30 25 17 28
27 24 22 15 10
 */

/**
 * DFS + DP 문제
 * DFS로 완전탐색을 진행하면서 끝점에서 부터 거꾸로 DP로 탐색을 하면서 얻을 가지의 경우를 더하면서 문제를 해결하자.
 */
public class 내리막길_1520 {

    private static int n,m;
    private static int[] dx = {0, 0, -1, 1}; //상하좌우
    private static int[] dy = {-1, 1, 0, 0};
    private static int map[][];
    private static int dp[][];


    //끝에서 부터 dp를 채워간다.
    private static int dfs(int y, int x) {

        if(y == n - 1 && x == m - 1) return 1;

        //아직 방문되지 않았다면
        if(dp[y][x] == -1) {
            dp[y][x] = 0;
            for (int i = 0; i < 4; i++) {
                int next_y = y + dy[i];
                int next_x = x + dx[i];
                if (next_x < 0 || next_y < 0 || next_x >= m || next_y >= n) continue;
                if (map[next_y][next_x] >= map[y][x]) continue;
                dp[y][x] += dfs(next_y, next_x);
            }
        }
        return dp[y][x];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dp = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dfs(0,0));
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(dp[i][j]).append("  ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
