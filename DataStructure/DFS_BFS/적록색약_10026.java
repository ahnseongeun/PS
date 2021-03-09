package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 적록색약_10026 {

    private static int n;
    private static int[] ColorCount;
    private static char arr[][];
    private static boolean visited[][];
    private static int[] dx = {0,0,-1,1}; // 상, 하, 좌, 우
    private static int[] dy = {-1,1,0,0};

    private static void bfsWithRedDiffGreen(int y, int x, char color) {

        for(int i = 0; i < 4; i++){
            int next_y = y + dy[i];
            int next_x = x + dx[i];
            if(next_y < 0 || next_x < 0 || next_x >= n || next_y >= n)
                continue;
            if(visited[next_y][next_x] || arr[next_y][next_x] != color)
                continue;

            visited[next_y][next_x] = true;
            bfsWithRedDiffGreen(next_y, next_x , color);
        }
    }


    public static void main(String[] args) throws  Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(input.readLine());

        arr = new char[n][n];
        for(int i = 0; i < n; i++){
            String str = input.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j);
            }
        }
        ColorCount = new int[3]; // 0 빨 1 초 2 파
        visited = new boolean[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    bfsWithRedDiffGreen(i,j, arr[i][j]);
                    if(arr[i][j] == 'R')
                        ColorCount[0]++;
                    if(arr[i][j] == 'G')
                        ColorCount[1]++;
                    if(arr[i][j] == 'B')
                        ColorCount[2]++;
                }
        sb.append(ColorCount[0] + ColorCount[1] + ColorCount[2] + " ");

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(arr[i][j] == 'R')
                    arr[i][j] = 'G';
            }
        }
        visited = new boolean[n][n];
        ColorCount = new int[3]; // 0 빨 1 초 2 파
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                if(!visited[i][j]) {
                    visited[i][j] = true;
                    bfsWithRedDiffGreen(i,j, arr[i][j]);
                    if(arr[i][j] == 'G')
                        ColorCount[1]++;
                    if(arr[i][j] == 'B')
                        ColorCount[2]++;
                }
        sb.append(ColorCount[1] + ColorCount[2]);
        System.out.println(sb);
    }
}
