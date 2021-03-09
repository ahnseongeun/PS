package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3 3
1 1 0
1 1 1
1 0 1
1 1 1
빈칸 0, 벽 1
 */

/*

현재 위치를 청소한다.
현재 위치에서 현재 방향을 기준으로 왼쪽방향부터 차례대로 탐색을 진행한다.
왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
로봇 청소기는 이미 청소되어있는 칸을 또 청소하지 않으며, 벽을 통과할 수 없다.
 */
public class 로봇청소기_14503 {

    private static int[][] arr;
    private static int dx[] = {0, 1, 0, -1}; //북, 동, 남, 서
    private static int dy[] = {-1, 0, 1, 0};
    private static int n;
    private static int m;
    private static int count;

    private static void robotCleaner(int y, int x, int direction) {

        //현재 위치를 청소한다.

        for(int i = 0; i < 4; i++){
            direction = (direction - 1 + 4) % 4;
            int next_x = x + dx[direction];
            int next_y = y + dy[direction];
            if(next_x < 0 || next_y < 0 || x >= m || y >= n) {
                continue;
            }
            if(arr[next_y][next_x] == 0) {
                arr[next_y][next_x] = 5;
                robotCleaner(next_y, next_x, direction);
                /**
                 * 여기서 리턴을 해주는 이유는?
                 * 전진을하고 다시 원래자리로 돌아오는 것이 아니기 때문에 독립적으로 가야한다.
                 * 그래서 return을 해줘야한다.
                 */
                return;
            }
        }
        int next_x = x - dx[direction];
        int next_y = y - dy[direction];
        if(arr[next_y][next_x] == 1)
            return;
        robotCleaner(next_y, next_x, direction);
    }

    private static void display() {
        int result = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                result += arr[i][j] == 5 ? 1 : 0;
            }
        }
        System.out.println(result);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n][m];

        st = new StringTokenizer(input.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(input.readLine());
            for (int j = 0; j < m; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
            }
        }

        if(arr[y][x] == 0)
            arr[y][x] = 5;
        robotCleaner(y, x, d);
        display();
    }
}
