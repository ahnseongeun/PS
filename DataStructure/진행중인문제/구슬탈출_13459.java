package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7 7
#######
#...RB#
#.#####
#.....#
#####.#
#O....#
#######
 */
public class 구슬탈출_13459 {

    private static int n, m;
    private static char[][] map;
    private static boolean[][][][] visited;
    private static final int[] dx = {0, 1, 0, -1}; //상우하좌
    private static final int[] dy = {-1, 0, 1, 0};

    private static int bfs(int red_y, int red_x, int blue_y, int blue_x) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{red_y, red_x, blue_y, blue_x, 0});
        visited[red_y][red_x][blue_y][blue_x] = true;

        //# 벽, . 길, R 빨간공, B 파란공, O 골인 지점
        while(!q.isEmpty()){
            int[] location = q.poll();
            red_y = location[0];
            red_x = location[1];
            blue_y = location[2];
            blue_x = location[3];
            int level = location[4];

            //10번이하로 움직이기
            if(level >= 10) {
                return 0;
            }

            for(int i = 0; i < 4; i++) {
                int next_red_y = red_y;
                int next_red_x = red_x;
                int next_blue_y = blue_y;
                int next_blue_x = blue_x;

                //빨간공 이동
                while(map[next_red_y + dy[i]][next_red_x + dx[i]] == '.'){
                    next_red_y += dy[i];
                    next_red_x += dx[i];
                }

                //파란공 이동
                while(map[next_blue_y + dy[i]][next_blue_x + dx[i]] == '.'){
                    next_blue_y += dy[i];
                    next_blue_x += dx[i];
                }

                if(map[next_red_y + dy[i]][next_red_x + dx[i]] == 'O'){
                    next_red_y += dy[i];
                    next_red_x += dx[i];
                }

                if(map[next_blue_y + dy[i]][next_blue_x + dx[i]] == 'O'){
                    next_blue_y += dy[i];
                    next_blue_x += dx[i];
                }

                if(map[next_blue_y][next_blue_x] == 'O')
                    continue;

                if(map[next_red_y][next_red_x] == 'O')
                    return 1;

                //둘의 이동 위치가 같다면 더 많이 이동한 것을 한칸 더 뒤로
                if(next_red_y == next_blue_y && next_red_x == next_blue_x){
                    int red = Math.abs(red_y - next_red_y) + Math.abs(red_x - next_red_x);
                    int blue = Math.abs(blue_y - next_blue_y) + Math.abs(blue_x - next_blue_x);
                    if (red > blue) {
                        next_red_y -= dy[i];
                        next_red_x -= dx[i];
                    } else {
                        next_blue_y -= dy[i];
                        next_blue_x -= dx[i];
                    }
                }

                //지나왔던 위치가 아니라면 visited
                if(!visited[next_red_y][next_red_x][next_blue_y][next_blue_x]){
                    visited[next_red_y][next_red_x][next_blue_y][next_blue_x] = true;
                    q.add(new int[]{next_red_y, next_red_x, next_blue_y, next_blue_x, level + 1});
                }
            }

        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new char[n][m];
        visited = new boolean[n][m][n][m];

        int red_x = 0;
        int red_y = 0;
        int blue_x = 0;
        int blue_y = 0;

        for(int i = 0; i < n; i++){
            String str = input.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'R'){
                    red_y = i; red_x = j;
                    map[i][j] = '.';
                }
                if(map[i][j] == 'B'){
                    blue_y = i; blue_x = j;
                    map[i][j] = '.';
                }
            }
        }

        System.out.println(bfs(red_y,red_x,blue_y,blue_x));
    }
}
