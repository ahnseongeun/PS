package DataStructure.진행중인문제;

import java.util.*;

/*
1110
1220
1001
0001
0003
0003
*/
class Solution {
    private static int numberOfArea = 0;
    private static int maxSizeOfOneArea = 0;
    private static boolean visited[][];
    private static int count = 0;
    private static int dx[] = {0,0,-1,1}; //상하좌우
    private static int dy[] = {-1,1,0,0};

    private static void dfs(int y, int x, int[][] picture,int m, int n){

        if(picture[y][x] == 0 || visited[y][x])
            return;
        visited[y][x] = true;
        count++;
        for(int i = 0; i < 4; i++) {
            int next_y = y + dy[i];
            int next_x = x + dx[i];
            if (next_y < 0 || next_x < 0 || next_y >= m || next_x >= n || visited[next_y][next_x])
                continue;
            if (picture[next_y][next_x] != picture[y][x])
                continue;
            dfs(next_y, next_x,  picture,m,n);
        }
    }
    private static void getPictureInformation(int m, int n, int[][] picture){

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(picture[i][j] != 0 && !visited[i][j]){
                    dfs(i,j,picture,m,n);
                    maxSizeOfOneArea = Math.max(maxSizeOfOneArea,count);
                    numberOfArea ++;
                    count  = 0;
                }
            }
        }
    }
    public int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        getPictureInformation(m,n,picture);
        return new int[]{numberOfArea, maxSizeOfOneArea};
    }
}

public class 카카오프렌트컬러링북_프로그래머스 {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.solution(6, 4, new int[][]{{1, 1, 1, 0},
                {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }
}
