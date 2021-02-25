package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 안전영역_2468 {

    private static int[][] arr;
    private static boolean[][] visited;
    private static int[] dx = {0,0,-1,1};//상하좌우
    private static int[] dy = {-1,1,0,0};

    private static void dfs(int y, int x, int height) {

        for(int i = 0; i < 4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(next_x < 0 || next_x >= arr.length || next_y < 0 || next_y >= arr.length)
                continue;
            if(visited[next_y][next_x] || arr[next_y][next_x] <= height)
                continue;
            visited[next_y][next_x] = true;
            dfs(next_y,next_x,height);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st;
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = 0;
        /**
         * 건물의 높이는 1 ~ 100 이고 비의 높의 제한은 없다.
         * 비에 관련해서는 아무 말도 없어서 0 ~ 100까지 범위로 설정해야한다.
         */
        for(int i = 0; i <= 100; i++) {
            visited = new boolean[n][n];
            int count = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(!visited[j][k] && arr[j][k] > i) {
                        visited[j][k] = true;
                        dfs(j,k,i);
                        count++;
                    }
                }
            }
            max = Math.max(max,count);
        }
        System.out.println(max);
    }
}
