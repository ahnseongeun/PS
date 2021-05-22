package CodingTest.구름;

import DataStructure.Stack.압축_1662_String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
5
....X
XXX.X
DDX..
.XX..
.X...
2 3 2 2
 */
public class Test2 {

    private static int n;
    private static char map[][];
    private static boolean visited[][][][];
    private static int dx[] = {0,1,0,-1};//상우하좌
    private static int dy[] = {-1,0,1,0};
    private static boolean arrival1 = false;
    private static boolean arrival2 = false;


    /**
     * 겹쳤을 경우를 어떻게 구별할까...
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    private static int bfs(int x1, int y1, int x2, int y2) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{y1,x1,y2,x2,0});
        visited[y1][x1][y2][x2] = true;

        while(!q.isEmpty()){
            int[] location = q.poll();

            if(arrival1 && arrival2)
                return 1;

            y1 = location[0];
            x1 = location[1];
            y2 = location[2];
            x2 = location[3];
            int level = location[4];

            //4방향
            for(int i = 0; i < 4; i++){
                int next_y1 = y1 + dy[i];
                int next_x1 = x1 + dx[i];
                int next_y2 = y2 + dy[i];
                int next_x2 = x2 + dx[i];

                if(!arrival1) {
                    //첫번째
                    if (next_y1 < 0 || next_x1 < 0 || next_y1 < n || next_x1 < n || map[next_y1][next_x1] != 'X') {

                    }else{
                        next_y1 = y1 - dy[i];
                        next_x1 = x1 - dx[i];
                        //도착했는지 검사
                        if (map[next_y1][next_x1] == 'D') {
                            arrival1 = true;
                        }
                    }
                }

                //두번째
                if (!arrival2) {

                    if(next_y2 < 0 || next_x2 < 0 || next_y2 >= n || next_x2 >= n || map[next_y2][next_x2] != 'X'){

                    }else{
                        next_y2 = y2 - dy[i];
                        next_x2 = x2 - dx[i];
                        if(map[next_y2][next_x2] == 'D'){
                            arrival2 = true;
                        }
                    }

                }

                //도착을 안했고 같다면 두번째 뒤로
                if(!arrival1 && !arrival2 && next_y2 == next_y1 && next_x2 == next_x1){
                    next_y2 = y2 - dy[i];
                    next_x2 = x2 - dx[i];
                }
                //큐에 넣기
                if(!visited[next_y1][next_x1][next_y2][next_x2]){
                    visited[next_y1][next_x1][next_y2][next_x2] = true;
                    q.add(new int[]{next_y1,next_x1,next_y2,next_x2,level + 1});
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        map = new char[n][n];
        visited = new boolean[n][n][n][n];
        for(int i = 0; i < n; i++){
            String str = input.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j);
            }
        }
        StringTokenizer st = new StringTokenizer(input.readLine());
        int x1 = Integer.parseInt(st.nextToken());
        int y1 = Integer.parseInt(st.nextToken());
        int x2 = Integer.parseInt(st.nextToken());
        int y2 = Integer.parseInt(st.nextToken());
        System.out.println(bfs(x1,y1,x2,y2));
    }
}
