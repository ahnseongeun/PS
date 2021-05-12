package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
5
4 3
####
#*@.
####
7 6
###.###
#*#.#*#
#.....#
#.....#
#..@..#
#######
7 4
###.###
#....*#
#@....#
.######
5 5
.....
.***.
.*@*.
.***.
.....
3 3
###
#@#
###
 */
/*
'.': 빈 공간
'#': 벽
'@': 상근이의 시작 위치
'*': 불
 */
public class 불_5427 {

    private static int col,row;
    private static char[][] map;
    private static boolean visited[][];
    private static int dx[] = {0,1,0,-1}; //상우하좌
    private static int dy[] = {-1,0,1,0}; //상우하좌
    private static int escape(int start_y, int start_x, ArrayList<int[]> fire) {
        int result = -1;

        Queue<int[]> q = new LinkedList<>();
        for(int[] tmp : fire)
            q.add(new int[]{tmp[0], tmp[1], 1, 0});
        q.add(new int[]{start_y, start_x, 0, 0}); //좌표, 사람 0 - fire 1, level

        while(!q.isEmpty()){
            int[] location = q.poll();
            int y = location[0];
            int x = location[1];
            int type = location[2];
            int level = location[3];
            for(int i = 0; i < 4; i++) {
                int next_x = x + dx[i];
                int next_y = y + dy[i];
                if(next_x < 0 || next_y < 0 || next_x >= row || next_y >= col){
                    if(type == 0)
                        return level + 1;
                    else
                        continue;
                }
                if(map[next_y][next_x] == '*' || map[next_y][next_x] == '#' || visited[next_y][next_x])
                    continue;
                visited[next_y][next_x] = true;
                q.add(new int[]{next_y, next_x, type, level + 1});
            }

        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            row = Integer.parseInt(st.nextToken());
            col = Integer.parseInt(st.nextToken());
            map = new char[col][row];
            visited = new boolean[col][row];
            ArrayList<int[]> fire = new ArrayList<>();

            int start_y = 0;
            int start_x = 0;
            for(int j = 0; j < col; j++){
                String str = input.readLine();
                for(int k = 0; k < row; k++){
                    map[j][k] = str.charAt(k);
                    if(map[j][k] == '@'){
                        start_y = j;
                        start_x = k;
                        map[j][k] = '.';
                    }else if(map[j][k] == '*'){
                        fire.add(new int[]{j,k});
                        visited[j][k] = true;
                    }
                }
            }

            int result = 0;
            if((result = escape(start_y,start_x,fire)) == -1){
                sb.append("IMPOSSIBLE").append("\n");
            }else{
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }
}
