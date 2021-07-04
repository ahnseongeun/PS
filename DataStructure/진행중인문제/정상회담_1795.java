package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
3 4
...1
....
2...
 */
public class 정상회담_1795 {

    private static int n,m;
    private static int[] dx = {-1, 1, 2, 2, 1, -1, -2, -2}; //상좌 상우 우상 우하 하우 하좌 좌하 좌상
    private static int[] dy = {-2, -2, -1, 1, 2, 2, 1, -1};
    private static int[][] map;
    private static int[][][] result; // 1. 몇개가 있는지, 2.최대의 경우는 몇인지

    private static void bfs(int key, int y1, int x1, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y1, x1, 0});
        visited[y1][x1] = true;
        while(!q.isEmpty()) {
            int[] location = q.poll();
            int y = location[0];
            int x = location[1];
            int cnt = location[2];
            for(int i = 0; i < key; i++) {
                for (int j = 0; j < 8; j++) {
                    int next_x = x + dx[j];
                    int next_y = y + dy[j];
                    if (next_x < 0 || next_y < 0 || next_y >= n || next_x >= m) continue;
                    if (visited[next_y][next_x]) continue;
                    visited[next_y][next_x] = true;
                    result[next_y][next_x][1] = Math.max(result[next_y][next_x][1], cnt + 1);
                    result[next_y][next_x][0]++;
                    q.add(new int[]{next_y, next_x, cnt + 1});
                }
            }
        }
        //display(visited);
    }

    private static void display(boolean visited[][]) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sb.append(visited[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int getMinMove(int target) {
        int answer = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(result[i][j][0] == target) answer = Math.min(answer,result[i][j][1]);
            }
        }
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        result = new int[n][m][2];
        HashMap<Integer,int[]> location = new HashMap<>();
        int targetCount = 0;
        for(int i = 0; i < n; i++){
            String str = input.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == '.') continue;
                location.put(map[i][j] - '0',new int[]{i,j});
                targetCount++;
                map[i][j] = '.';
            }
        }
        for(int key : location.keySet()){
            boolean[][] visited = new boolean[n][m];
            bfs(key,location.get(key)[0],location.get(key)[1],visited);
        }

        System.out.println(getMinMove(targetCount));
    }
}
