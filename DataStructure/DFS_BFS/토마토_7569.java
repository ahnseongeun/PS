package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//1은 익은 토마토, 0은 안익은 토마토, -1은 비어있음
public class 토마토_7569 {

    static int m,n,h;
    static int arr[][][];
    static boolean visited[][][];
    static int result;
    static int zeroCount = 0;
    static int dx[] = {0,0,0,1,0,-1}; //상 하 위 오른쪽 아래 왼쪽
    static int dy[] = {0,0,-1,0,1,0};
    static int dz[] = {1,-1,0,0,0,0};

    private static void bfs(Queue<int[]> q) {

        while(!q.isEmpty()){
            int[] temp = q.poll();
            int x = temp[1];
            int y = temp[0];
            int z = temp[2];
            int count = temp[3];
            for(int i = 0; i < 6; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                int next_z = z + dz[i];
                if(next_x < 0 || next_x >= m || next_y < 0 || next_y >= n || next_z < 0 || next_z >= h)
                    continue;
                if(arr[next_y][next_x][next_z] == 0 && !visited[next_y][next_x][next_z]){
                    visited[next_y][next_x][next_z] = true;
                    arr[next_y][next_x][next_z] = 1;
                    zeroCount--;
                    result = Math.max(count, result);
                    q.add(new int[]{next_y,next_x,next_z,count+1});
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        arr = new int[n][m][h];
        visited = new boolean[n][m][h];
        result = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0 ; i < h; i++){
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(input.readLine());
                for(int k = 0 ; k < m; k++){
                    int num = Integer.parseInt(st.nextToken());
                    arr[j][k][i] = num;
                    if(num == 1) {
                        queue.add(new int[]{j, k, i,1});
                        visited[j][k][i] = true;
                    }
                    if(num == 0)
                        zeroCount++;
                }
            }
        }

        bfs(queue);
        System.out.println(zeroCount == 0 ? result : -1);
    }
}
