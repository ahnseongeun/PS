package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 문제접근법 - 완전탐색을 했을 경우 시간 복잡도가 통과하는지 확인하는지가 첫번째 문제
 * 가로 50, 세로 50 이기 때문에 최대 2500의 배열의 원소의 수
 * 각 원소의 자리마다 50*50번의 탐색
 * 즉, 최악의 경우 2500 * 2500의 경우의 대략 6백만번의 연산 발생생 */
public class 보물섬_2589 {

    private static int n;
    private static int m;
    private static char arr[][];
    private static boolean visited[][];
    private static int[] dx = {0,0,-1,1}; //상하좌우
    private static int[] dy = {-1,1,0,0};

    private static int bfs(int y, int x) {

        Queue<int[]> q = new LinkedList<>();
        int max = 0;
        q.add(new int[]{x,y,0});
        visited[y][x] = true;

        while(!q.isEmpty()){
            int[] tmp = q.poll();
            x = tmp[0];
            y = tmp[1];
            int count = tmp[2];

            max = Math.max(max,count);

            for(int i = 0; i < 4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= m || next_y >= n )
                    continue;

                if(visited[next_y][next_x] || arr[next_y][next_x] == 'W')
                    continue;

                visited[next_y][next_x] = true;
                //System.out.println(next_x + " " + next_y + " " + count);
                q.add(new int[]{next_x, next_y, count + 1});
            }
        }
        //System.out.println(max);
        return max;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new char[n][m];

        for(int i = 0; i < n; i++){
            String str = input.readLine();
            for(int j = 0; j < m; j++ )
                arr[i][j] = str.charAt(j);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(arr[i][j] == 'W')
                    continue;
                visited = new boolean[n][m];
                max = Math.max(max,bfs(i,j));
            }
        }
        System.out.println(max);
    }

}
