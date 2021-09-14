package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


/*
1. 외각을 판단하는 방법은?
- 0인 곳에서 BFS를 통해서 지워질 곳을 표시한다.
- 1이면 0으로 바꾼다.
 */
/*
13 12
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 1 1 0 0 0
0 1 1 1 0 0 0 1 1 0 0 0
0 1 1 1 1 1 1 0 0 0 0 0
0 1 1 1 1 1 0 1 1 0 0 0
0 1 1 1 1 0 0 1 1 0 0 0
0 0 1 1 0 0 0 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 1 1 1 1 1 1 1 0 0 0
0 0 0 0 0 0 0 0 0 0 0 0
 */
public class 치즈_2636 {

    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1}; // 상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int n, m;
    static int count = 0;

    static boolean check() {

        visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<int[]>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        boolean result = false;

        while(!q.isEmpty()) {

            int[] node = q.poll();
            int y = node[0];
            int x = node[1];

            for(int i = 0; i < 4; i++) {
                int next_y = y + dy[i];
                int next_x = x + dx[i];
                if(next_y >= n || next_x >= m || next_y < 0 || next_x < 0 || visited[next_y][next_x]) continue;

                visited[next_y][next_x] = true;
                if( map[next_y][next_x] == 1) {
                    map[next_y][next_x] = 0;
                    count++;
                    result = true;
                    continue;
                } else {
                    q.add(new int[]{next_y, next_x});
                }
            }
        }
        if(!result) return false;

        return true;
    }

    public static void main(String[] args) throws Exception{
        // TODO Auto-generated method stub

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        int result = 0;
        while(check()) {
            result = count;
            count = 0;
            cnt++;
        }
        System.out.println(cnt);
        System.out.println(result);
    }

}

