package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3 7
3942178
1234567
9123532
1 10
2H3HH4HHH5
4 4
3994
9999
9999
2924
 */
public class 게임_1103 {

    private static int n;
    private static int m;
    private static boolean[][] visited;
    private static int[][] dp;

    private static boolean move(int y, int x, char[][] map) {
        return y >= 0 && x >= 0 && y < n && x < m && map[y][x] != 'H';
    }

    private static int dfs(char[][] map, int y, int x) {

        if(visited[y][x]) return -1;
        if( dp[y][x] != 0) return dp[y][x];
        int jump_count = map[y][x];
        //상하좌우 이동
        if(move(y, x - jump_count, map)) {
            visited[y][x - jump_count] = true;
            dp[y][x] = Math.max(dp[y][x], dfs(map,y, x - jump_count) + 1);
            visited[y][x - jump_count] = false;
        }

        if(move(y,x + jump_count, map)) {
            visited[y][x + jump_count] = true;
            dp[y][x] = Math.max(dp[y][x], dfs(map,y, x + jump_count) + 1);
            visited[y][x - jump_count] = true;
        }

        if(move(y - jump_count, x, map)) {
            visited[y - jump_count][x] = true;
            dp[y][x] = Math.max(dp[y][x], dfs(map,y - jump_count, x) + 1);
            visited[y - jump_count][x] = false;
        }

        if(move(y + jump_count, x, map)) {
            visited[y + jump_count][x] = true;
            dp[y][x] = Math.max(dp[y][x], dfs(map,y + jump_count, x) + 1);
            visited[y + jump_count][x] = false;
        }



        return dp[y][x];
   }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        char[][] map = new char[n][m];

        for(int i = 0; i < n; i++) {
            String str = input.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        visited = new boolean[n][m];
        dp = new int[n][m];
        System.out.println(dfs(map, 0, 0));
    }
}
