package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
2
10 8 17
0 0
1 0
1 1
4 2
4 3
4 5
2 4
3 4
7 4
8 4
9 4
7 5
8 5
9 5
7 6
8 6
9 6
10 10 1
5 5
 */
public class 유기농배추_1012 {
    static boolean visited[][];
    static int dx[] = {0,0,-1,1}; //상하좌우
    static int dy[] = {-1,1,0,0};
    static int n;
    static int m;

    private static void checkVisit(int[][] arr, int y, int x) {
        if (visited[y][x])
            return;
        visited[y][x] = true;
        for(int i = 0;i < 4; i++){
            if(y+dy[i] < 0 || y+dy[i] >= n || x+dx[i] < 0 || x+dx[i] >= m ||
                    visited[y+dy[i]][x+dx[i]] || arr[y+dy[i]][x+dx[i]] == 0)
                continue;
            checkVisit(arr,y+dy[i],x+dx[i]);
        }
    }

    private static int searchWarm(int[][] arr) {
        int count = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ;j++){
                if(arr[i][j] == 1 && !visited[i][j]){
                    checkVisit(arr,i,j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void display() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m ;j++){
                sb.append(visited[i][j]+" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int total = Integer.parseInt(input.readLine());

        for(int i = 0; i < total; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int arr[][]= new int[n][m];
            visited = new boolean[n][m];
            //배추 위치 삽입
            for(int j = 0;j < k;j++){
                st = new StringTokenizer(input.readLine());
                int m1 = Integer.parseInt(st.nextToken());
                int n1 = Integer.parseInt(st.nextToken());
                arr[n1][m1] = 1;
            }

            sb.append(searchWarm(arr)+"\n");
        }
        System.out.println(sb);

    }
}
