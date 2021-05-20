package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 트리에서 깊게 탐색해야하는 경우에는 DFS를 사용하자.
 * visited 배열은 필요가 없다. check를 이용해서 이미 지나온 알파벳은 다시 돌아 갈 수가 없기 때문에.
 */
public class 알파벳_dfs_1987 {

    private static char map[][];
    private static boolean check[];
    private static int dx[] = {0,0,-1,1}; //상하좌우
    private static int dy[] = {-1,1,0,0};
    private static int r,s;
    private static int max = -1;


    private static void dfs(int y, int x, int cnt) {

        max = Math.max(max,cnt);

        for(int i = 0; i < 4; i++){
            int next_y = y + dy[i];
            int next_x = x + dx[i];
            if(next_y < 0 || next_x < 0 || next_y >= r || next_x >= s)
                continue;
            if(check[map[next_y][next_x] - 'A'])
                continue;
            check[map[next_y][next_x] - 'A'] = true;
            dfs(next_y,next_x,cnt + 1);
            check[map[next_y][next_x] - 'A'] = false;
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        map = new char[r][s];
        check = new boolean[26];
        for(int i = 0; i < r; i++){
            String str = input.readLine();
            for(int j = 0; j < s; j++){
                map[i][j] = str.charAt(j);
            }
        }
        check[map[0][0] - 'A'] = true;
        dfs(0,0,1);
        System.out.println(max);
    }
}
