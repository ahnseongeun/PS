package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
3 3
D.*
...
.S.
 */
public class 탈출_3055 {

    private static char[][] map;
    private static int target_x = 0;
    private static int target_y = 0;
    private static int start_x = 0;
    private static int start_y = 0;
    private static int dy[] = {-1, 1, 0, 0}; //상, 하, 좌, 우
    private static int dx[] = {0, 0, -1, 1};


    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            String str = input.readLine();
            for(int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);

                if(map[i][j] == 'S') {
                    start_y = i;
                    start_x = j;
                }
                if(map[i][j] == 'D') {
                    target_y = i;
                    target_x = j;
                }
                if(map[i][j] == '*') {
                    q.add(new int[]{i, j, 1, 0});
                }
            }
        }
        int result = -1;
        q.add(new int[]{start_y, start_x ,0, 0});

        while(!q.isEmpty()) {
            int[] location = q.poll();
            int y = location[0];
            int x = location[1];
            int type = location[2];
            int cnt = location[3];

            if(y == target_y && x == target_x) {
                result = cnt;
                break;
            }

            for(int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if(next_x < 0 || next_y < 0 || next_y >= n || next_x >= m ) continue;
                if( type == 0 && (map[next_y][next_x] == '.' || map[next_y][next_x] == 'D')) {
                    map[next_y][next_x] = 'S';
                    q.add(new int[]{next_y, next_x, 0, cnt + 1});
                }
                if( type == 1 && (map[next_y][next_x] == '.' || map[next_y][next_x] == 'S')) {
                    map[next_y][next_x] = '*';
                    q.add(new int[]{next_y, next_x, 1, cnt + 1});
                }
            }

        }


        System.out.println(result == -1 ? "KAKTUS" : result);
    }
}
