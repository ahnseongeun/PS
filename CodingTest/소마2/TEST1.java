package CodingTest.소마2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
public class TEST1 {

    private static int n;
    private static int m;
    private static int arr[][];
    private static int dx[] = {0,0,-1,1}; //상하좌우
    private static int dy[] = {-1,1,0,0}; //상하좌우
    private static boolean keyCheck;
    private static boolean boxCheck;

    private static void display(){
        StringBuilder sbb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                sbb.append(arr[i][j]+" ");
            }
            sbb.append("\n");
        }
        System.out.println(sbb);
    }

    private static void dfs(int start_y, int start_x) {
        arr[start_y][start_x] = 5;
        for(int i = 0; i < 4; i++){
            int next_y = start_y+ dy[i];
            int next_x = start_x+ dx[i];
            if(next_y < 0 || next_x < 0 || next_y >= n || next_x >= m)
                continue;

            //벽이거나 지나왔거나
            if(arr[next_y][next_x] == 1 || arr[next_y][next_x] == 5)
                continue;

            if(arr[next_y][next_x] == 4){
                keyCheck = true;
            }

            if(arr[next_y][next_x] == 2){
                boxCheck = true;
            }
            dfs(next_y,next_x);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //수
        int num = Integer.parseInt(input.readLine());

        for(int i = 0; i < num; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            keyCheck = false;
            boxCheck = false;
            int start_y = 0;
            int start_x = 0;
            arr = new int[n][m];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(input.readLine());
                for (int k = 0; k < m; k++) {
                    int num1 = Integer.parseInt(st.nextToken());
                    arr[j][k] = num1;
                    if (num1 == 3) {
                        start_y = j;
                        start_x = k;
                    }
                }
            }
            dfs(start_y, start_x);
            //System.out.println(keyCheck);
            //System.out.println(boxCheck);
            if (keyCheck && boxCheck)
                sb.append(1 + "\n");
            else
                sb.append(0 + "\n");
            //display();
        }
        System.out.println(sb);
    }
}
