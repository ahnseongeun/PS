package DataStructure.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
0
 */
public class 녹색옷입은애가젤다지_4485 {

    private static int map[][];
    private static int visited[][];
    private static int dx[] = {0, 0, -1, 1}; //상하좌우
    private static int dy[] = {-1, 1, 0, 0};

    private static int dijkstra(int n) {

        int x = 0;
        int y = 0;
        Queue<int[]> q = new LinkedList<>();
        visited[y][x] = map[y][x];

        while(!q.isEmpty()){
            int[] location = q.poll();
            y = location[0];
            x = location[1];

            for(int i = 0; i < 4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= n)
                    continue;

                if(visited[next_y][next_x] > visited[y][x] + map[next_y][next_x]){
                    visited[next_y][next_x] = visited[y][x] + map[next_y][next_x];
                    q.add(new int[]{next_y, next_x});
                }
            }
        }

        return visited[n - 1][n - 1];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;
        int cnt = 1;
        while((n = Integer.parseInt(input.readLine())) != 0){

            map = new int[n][n];
            visited = new int[n][n];

            for(int i = 0; i < n; i++){
                StringTokenizer st = new StringTokenizer(input.readLine(), " ");
                Arrays.fill(visited[i], 2000000);

                for(int j = 0; j < n; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            sb.append("Problem " + cnt++ + ": " + dijkstra(n) + "\n");
        }
        System.out.println(sb);
    }
}
