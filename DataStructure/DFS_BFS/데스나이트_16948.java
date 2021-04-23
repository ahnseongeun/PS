package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
6 6 0 1
 */
public class 데스나이트_16948 {

    private static int n,r2,c2;
    private static boolean[][] visited;
    private static int[] dx = {-1,1,2,1,-1,-2};
    private static int[] dy = {-2,-2,0,2,2,0};

    //r이 y, c가 x
    private static int bfs(int r1, int c1) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r1,c1,0});
        visited[r1][c1] = true;
        while(!q.isEmpty()){
            int tmp[] = q.poll();
            int y = tmp[0];
            int x = tmp[1];
            int cnt = tmp[2];

            if(y == r2 && x == c2)
                return cnt;

            for(int i = 0; i < 6; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= n || visited[next_y][next_x])
                    continue;

                visited[next_y][next_x] = true;
                q.add(new int[]{next_y, next_x, cnt + 1});
            }

        }
        return -1;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());

        StringTokenizer st = new StringTokenizer(input.readLine());
        int r1 = Integer.parseInt(st.nextToken());
        int c1 = Integer.parseInt(st.nextToken());
        r2 = Integer.parseInt(st.nextToken());
        c2 = Integer.parseInt(st.nextToken());
        visited = new boolean[n][n];

        System.out.println(bfs(r1,c1));
    }
}
