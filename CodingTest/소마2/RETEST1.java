package CodingTest.소마2;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 소마 문제 1
 * 시작위치 3
 * 상자 4
 * 열쇠 2
 * 열쇠랑 상자를 찾을수 있으면 1
 * 없으면 0
 */
/*
2
5 6
0 0 1 0 2 0
1 0 1 0 0 0
0 0 1 1 1 0
0 3 0 1 0 0
4 0 0 0 0 0
5 6
0 0 1 0 2 0
1 0 1 0 0 0
0 0 1 1 1 0
0 3 0 1 0 0
4 0 0 1 0 0
 */
public class RETEST1 {

    private static int n;
    private static int m;
    private static int map[][];
    private static boolean visited[][];
    private static int[] dx = {0,0,-1,1}; //상,하,좌,우
    private static int[] dy = {-1,1,0,0};
    private static boolean keyCheck;
    private static boolean boxCheck;

    private static void searchMap(int y, int x) {

        visited[y][x] = true;

        for(int i = 0; i < 4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x < 0 || next_y < 0 || next_x >= m || next_y >= n)
                continue;

            if(map[next_y][next_x] == 1 || visited[next_y][next_x])
                continue;

            if(map[next_y][next_x] == 2){
                keyCheck = true;
            }else if(map[next_y][next_x] == 4){
                boxCheck = true;
            }else{
                searchMap(next_y,next_x);
            }

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int total = Integer.parseInt(input.readLine());

        for(int i = 0; i < total; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map = new int[n][m];
            visited = new boolean[n][m];
            int x = 0;
            int y = 0;
            boxCheck = false;
            keyCheck = false;

            for(int j = 0; j < n; j++){
                st = new StringTokenizer(input.readLine());
                for(int k = 0; k < m; k++){
                    int num = Integer.parseInt(st.nextToken());
                    map[j][k] = num;
                    if(num == 3){
                        y = j;
                        x = k;
                    }
                }
            }

            searchMap(y,x);
            if(keyCheck && boxCheck)
                System.out.println(1);
            else
                System.out.println(0);
        }


    }
}
