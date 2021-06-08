package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
8
11100110
11010010
10011010
11101100
01000111
00110001
11011000
11000111
 */

/**
 * 어떤식으로 접근할까??
 * 1이라면 그냥 가면 되고 0이라면 바꾸는데 바꾼 값 보다 더 적은 값이 들어 있다면 바꾸지 않는다.
 */
public class 미로만들기_2665 {

    private static int map[][];
    private static int visited[][];
    private static int dx[] = {0, 0, -1, 1}; //상,하, 좌, 우
    private static int dy[] = {-1, 1, 0, 0};

    private static int dijkstra(int y, int x, int n) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y, x});
        visited[y][x] = 0;

        while(!q.isEmpty()){
            int[] location = q.poll();
            y = location[0];
            x = location[1];

            for(int i = 0; i < 4; i++){
                int next_y = y + dy[i];
                int next_x = x + dx[i];

                if(next_x < 0 || next_y < 0 || next_y >= n || next_x >= n)
                    continue;


                if(visited[next_y][next_x] <= visited[y][x]) continue;

                //0은 벽 1 이동 가능
                if(map[next_y][next_x] == 1){
                    visited[next_y][next_x] = visited[y][x];
                }else{
                    visited[next_y][next_x] = visited[y][x] + 1;
                }
                q.add(new int[]{next_y, next_x});

            }
        }
        return visited[n - 1][n - 1];
    }


    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        map = new int[n][n];
        visited = new int[n][n];

        for(int i = 0; i < n; i++){
            String str = input.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
                visited[i][j] = 10000;
            }
        }

        System.out.println(dijkstra(0,0,n));
    }
}
