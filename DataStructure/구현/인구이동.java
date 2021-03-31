package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
2 20 50
50 30
20 40
 */
public class 인구이동 {

    private static int country[][];
    private static int dx[] ={0,0,-1,1}; //상,하,좌,우
    private static int dy[] ={-1,1,0,0};
    private static int check[][];
    private static int count = 0;
    private static int sum = 0;
    private static boolean flag;
    private static int n,l,r;

    private static boolean moveCountryCheck() {
        int cnt = 0;
        flag = false;
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(check[i][j] == 0){
                    check[i][j] = ++cnt; //연합 번호
                    sum = country[i][j];
                    count = 1;
                    dfs(i,j,cnt);
                    int avg = sum / count;
                    for(int k = 0; k < n; k++){
                        for(int t = 0; t < n; t++){
                            if(check[k][t] == cnt)
                                country[k][t] = avg;
                        }
                    }
                }
            }
        }
        return flag;
    }

    private static void dfs(int y, int x, int cnt) {

        for(int i = 0; i < 4; i++){
            int next_x = x + dx[i];
            int next_y = y + dy[i];

            if(next_x < 0 || next_y < 0 || next_x >=n || next_y >= n || check[next_y][next_x] != 0)
                continue;

            if(Math.abs(country[y][x]-country[next_y][next_x]) >= l && Math.abs(country[y][x]-country[next_y][next_x]) <= r){
                check[next_y][next_x] = cnt;
                sum += country[next_y][next_x];
                dfs(next_y,next_x,cnt);
                count ++;
                flag = true;
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        country = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        check = new int[n][n];
        int total = 0;
        while(moveCountryCheck()) {
            //display();
            check = new int[n][n];
            total++;
        }
        System.out.println(total);
    }

    private static void display() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(check[i][j] +" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

        sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(country[i][j] +" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
