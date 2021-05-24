package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
4
0 1 2 2
1 1 1 1
2 2 2 2
0 0 1 0
 */
//0 -> 1 -> 2 순서로 반복되어야 한다.
public class 우유도시_14722 {

    private static int arr[][];
    private static int dp[][];
    private static int dx[] = {1,0}; //동, 남
    private static int dy[] = {0,1};
    private static int n;

    private static void dfs(int y, int x, int cnt, int state) {
        if(y == n - 1 && x == n - 1){
            return;
        }

        for(int i = 0; i < 2; i++){
            int next_y = y + dy[i];
            int next_x = x + dx[i];

            //다음 state이라면 dp 변경
            if(arr[next_y][next_x] == (state + 1) % 3){
                if(dp[next_y][next_x] < dp[y][x] + 1) {
                    dp[next_y][next_x] = dp[y][x] + 1;
                    dfs(next_y,next_x,cnt + 1, (state + 1) % 3);
                }
            //다음 state이 아니라면 max를 이용해서 진행
            }else if(arr[next_y][next_x] == state){
                if(dp[next_y][next_x] < dp[y][x]) {
                    dp[next_y][next_x] = dp[y][x];
                    dfs(next_y, next_x, cnt, state);
                }
            }else{
                if(dp[next_y][next_x] == 0)
                    dfs(next_y,next_x,cnt, state);
            }

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        arr = new int[n][n];
        dp = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int state = -1;
        if(arr[0][0] == 0){
            state = 0;
            dp[0][0] = 1;
        }
        dfs(0, 0, 0, state);
        System.out.println(getMax());
    }

    private static int getMax() {
        int max = 0;
        //StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n ; i++){
            for(int j = 0; j < n; j++){
                max = Math.max(dp[i][j],max);
        //        sb.append(dp[i][j] + " ");
            }
        //    sb.append("\n");
        }
        //System.out.println(sb);
        return max;
    }
}
