package DataStructure.구현;

import com.sun.security.jgss.GSSUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
0은 빈 칸, 1은 벽, 2는 바이러스
 */

/**
 * 1. 바이러스를 기준으로 3개의 벽을 세울 수 있는 모든 경우의 수를 탐색한다.
 * 2. 모든 경우의 수를 탐색 했을 경우 그때의 0의 개수를 출력한다.
 */
public class 연구소_14502 {

    private static int n, m, cnt = 0;
    private static int[][] map;
    private static final int[] dx = {0, 1, 0, -1}; //상우하좌
    private static final int[] dy = {-1, 0 , 1, 0};
    private static ArrayList<int[]> virus;
    private static int[][] copyMap;

    private static int check() {

        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ; j++){
                copyMap[i][j] = map[i][j];
            }
        }

        Queue<int[]> q = new LinkedList<>(virus);
        while(!q.isEmpty()) {
            int[] location = q.poll();
            for (int j = 0; j < 4; j++) {
                int next_y = location[0] + dy[j];
                int next_x = location[1] + dx[j];

                if (next_y < 0 || next_x < 0 || next_y >= n || next_x >= m)
                    continue;
                if(copyMap[next_y][next_x] == 0) {
                    copyMap[next_y][next_x] = 2;
                    q.add(new int[]{next_y, next_x});
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(copyMap[i][j] == 0) count++;
            }
        }

        return count;
    }

    private static void getSafetyZone() {

        for(int y1 = 0; y1 < n; y1++){
            for(int x1 = 0; x1 < m; x1++){
                if(map[y1][x1] == 0) {
                    map[y1][x1] = 1;
                    for (int y2 = 0; y2 < n; y2++) {
                        for (int x2 = 0; x2 < m; x2++) {
                            if (map[y2][x2] == 0) {
                                map[y2][x2] = 1;
                                for (int y3 = 0; y3 < n; y3++) {
                                    for (int x3 = 0; x3 < m; x3++) {
                                        if (map[y3][x3] == 0) {
                                            map[y3][x3] = 1;
                                            cnt = Math.max(check(), cnt);
                                            map[y3][x3] = 0;
                                        }
                                    }
                                }
                                map[y2][x2] = 0;
                            }
                        }
                    }
                    map[y1][x1] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        copyMap = new int[n][m];
        virus = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2)
                    virus.add(new int[]{i, j});
            }
        }
        getSafetyZone();
        System.out.println(cnt);
    }
}
