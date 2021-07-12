package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
7 8
0 0 0 0 0 0 1 1
1 1 0 0 0 0 1 1
1 1 0 0 0 0 0 0
1 1 0 0 0 1 1 0
0 0 0 0 0 1 1 0
0 0 0 0 0 0 0 0
1 1 1 1 1 1 1 1
 */

/**
 * 1. 섬의 개수를 파악한다.
 * 2. 다리의 개수가 섬의 개수 - 1개보다 작다면 만들 수 없는 것이다.
 * 3. 섬들 간의 모든 다리를 놓으면서 기록한다.
 * 4. 다리들은 검사하면서 최소가 되면서 조건을 만족하는
 * 다리들은 찾는다.
 */
public class 다리만들기2_17272 {

    private static int n;
    private static int m;
    private static int[][] map;
    private static int[][] island;
    private static int[][] bridge;
    private static int[] dx = {0, 0, -1, 1}; //상하좌우
    private static int[] dy = {-1, 1, 0, 0};

    private static void setIsland(int y, int x, int cnt) {


        island[y][x] = cnt;

        for(int i = 0; i < 4; i++) {
            int next_y = y + dy[i];
            int next_x = x + dx[i];
            if(next_y < 0 || next_x < 0 || next_y >= n || next_x >= m) continue;
            if(map[next_y][next_x] == 0 || island[next_y][next_x] != 0) continue;
            setIsland(next_y,next_x,cnt);
        }
    }

    private static void setBridge(int y, int x) {

        int islandNumber = island[y][x];
        for(int i = 0; i < 4; i++) {
            int cnt = 0;
            int next_y = y + dy[i];
            int next_x = x + dx[i];
            while(true) {
                if (next_x < 0 || next_y < 0 || next_y >= n || next_x >= m) break;
                if ( island[next_y][next_x] == 0) {
                    cnt++;
                    next_y += dy[i];
                    next_x += dx[i];
                } else if ( island[next_y][next_x] != islandNumber) {
                    if(cnt <= 1) break;
                    bridge[islandNumber][island[next_y][next_x]] = cnt;
                    break;
                } else {
                    next_y += dy[i];
                    next_x += dx[i];
                }
            }
        }
    }

    public static void main( String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb =  new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        island = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m ; j ++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //섬의 개수 구하기
        int islandCount = 1;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 1 && island[i][j] == 0) {
                    setIsland(i,j, islandCount++);
                }
            }
        }


        bridge = new int[islandCount][islandCount];
        PriorityQueue<int[]> pq = new PriorityQueue<>();
        int bridgeCount = 0;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(island[i][j] == 0) continue;
                setBridge(i,j);
                bridgeCount++;
            }
        }

        for(int i = 1; i < islandCount; i++) {
            for(int j = 1; j < islandCount; j++) {
                sb.append(bridge[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);


    }
}
