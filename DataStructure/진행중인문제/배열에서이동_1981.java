package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5
1 1 3 6 8
1 2 2 5 5
4 4 0 3 3
8 0 2 3 4
4 3 0 2 1
 */

/**
 * 완전 탐색을 할 경우 시간복잡도는?
 * 1. 모든 인덱스를 담은 배열을 만든다.
 * 2. 이분 탐색으로 최댓값과 최솟값을 이용해서 (최댓값 - 최솟값)을 찾는다.
 * 3. 해당 차를 기준으로 BFS를 통해서 1,1에서 N - 1, N - 1으로 갈 수 있는지 찾는다.
 */
public class 배열에서이동_1981 {

    static int[][] arr;
    static int[][] visited;
    static int[] dx = {0, 1, 0, -1}; //상, 우, 하, 좌
    static int[] dy = {-1, 0, 1, 0}; //상, 우, 하, 좌
    static int n;

    static void bfs(int y, int x) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x, arr[y][x]}); // y, x, max 값, max - min의 최소값
        visited[y][x] = 1000000000;

        while(!q.isEmpty()) {

            int[] node = q.poll();
            y = node[0];
            x = node[1];
            int maxValue = node[2];

            if( y == n - 1 && x == n - 1) {
                continue;
            }
            for(int i = 0; i < 4; i++) {
                int next_y = y + dy[i];
                int next_x = x + dx[i];
                if(next_y < 0 || next_x < 0 || next_y >= n || next_x >= n) continue;
                if(!check()) continue;
                visited[y][x] = maxValue - arr[y][x];
                q.add(new int[]{next_y, next_x, maxValue});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        arr = new int[n][n];
        visited = new int[n][n];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs(0,0);
    }
}
