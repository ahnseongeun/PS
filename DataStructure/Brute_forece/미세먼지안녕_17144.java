package DataStructure.Brute_forece;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
7 8 1
0 0 0 0 0 0 0 9
0 0 0 0 3 0 0 8
-1 0 5 0 0 0 22 0
-1 8 0 0 0 0 0 0
0 0 0 0 0 10 43 0
0 0 5 0 15 0 0 0
0 0 40 0 0 0 20 0
 */
public class 미세먼지안녕_17144 {
//우상좌하, 우 하 좌 상
    private static int y;
    private static int x;
    private static int n;
    private static int start_x;
    private static int start_y;
    private static int dx[] = {1, 0, -1, 0}; //우상좌하
    private static int dy[] = {0, -1, 0, 1};
    private static int arr[][];
    private static int dest[][];

    private static void dest_expension() {
        dest = new int[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(arr[i][j] == 0)
                    continue;

                int sum = arr[i][j] / 5;

                for(int k = 0; k < 4; k++){
                    int next_x = j + dx[k];
                    int next_y = i + dy[k];

                    if(next_x < 0 || next_y < 0 || next_x >= x || next_y >= y || arr[next_y][next_x] == -1)
                        continue;

                    dest[next_y][next_x] += sum;
                    arr[i][j] -= sum;
                }
            }
        }

        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                arr[i][j] += dest[i][j];
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        arr = new int[y][x];

        for(int i = 0; i < y; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < x; j++){
                int num = Integer.parseInt(st.nextToken());
                arr[i][j] = num;
                if(arr[i][j] == -1){
                    start_x = j;
                    start_y = i;
                }
            }
        }
        for(int i = 0; i < n; i++){
            dest_expension();
            airExpension(start_y - 1,start_x,1);
            airExpension(start_y,start_x,3);
        }
        System.out.println(display());
    }

    private static void airExpension(int start_y, int start_x, int val) {

        int prev = 0;
        int cnt = 0;
        int next_y = start_y;
        int next_x = start_x + 1;
        while(true){
            //다시 초기 위치로 돌아오면 끝
            if(next_y == start_y && next_x == start_x){
                return;
            }

            //교환
            int tmp = prev; // 이전 값을 tmp에 저장
            //System.out.println(next_y + " " + next_x);
            prev = arr[next_y][next_x]; //
            arr[next_y][next_x] = tmp;

            //한칸 전진
            next_y = next_y + dy[cnt];
            next_x = next_x + dx[cnt];

            //경계에 부딛히면 방향 전환
            if(next_x < 0 || next_y < 0 || next_x >= x || next_y >= y){
                next_y -= dy[cnt];
                next_x -= dx[cnt];
                cnt = (cnt + val) % 4;
                next_y += dy[cnt];
                next_x += dx[cnt];
            }

        }
    }

    private static int display() {
        //StringBuilder sb = new StringBuilder();
        int sum = 0;
        for(int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(arr[i][j] == -1)
                    continue;
                sum += arr[i][j];
                //sb.append(arr[i][j] + " ");
            }
            //sb.append("\n");
        }
        //System.out.println(sb);
        return sum;
    }

}
