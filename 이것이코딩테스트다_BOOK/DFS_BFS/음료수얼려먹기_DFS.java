package 이것이코딩테스트다_BOOK.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
4
5
00110
00011
11111
00000
 */
public class 음료수얼려먹기_DFS {
    static boolean visited[][];
    static int dx[]={0,0,-1,1};//상하좌우
    static int dy[]={1,-1,0,0,};
    static int n;
    static int m;
    static boolean dfs(int[][] arr, int x, int y){
        if(visited[y][x])
            return false;
        visited[y][x]=true;
        for(int i=0;i<4;i++){
            if(y+dy[i]<0||y+dy[i]>n-1||x+dx[i]<0||x+dx[i]>m-1)
                continue;
            dfs(arr,x+dx[i],y+dy[i]);
        }
        return true;
    }

    static void display(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                sb.append(visited[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb=new StringBuilder();
        n=Integer.parseInt(input.readLine());
        m=Integer.parseInt(input.readLine());
        int arr[][]=new int[n][m];
        visited=new boolean[n][m];
        int count=0;
        for(int i=0;i<n;i++){
            String str=input.readLine();
            for(int j=0;j<m;j++){
                int num=(str.charAt(j)-'0');
                arr[i][j]=num;
                if(num==1){
                    visited[i][j]=true;
                }
            }
        }
        display();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (dfs(arr, j, i)) {
                    count++;
                    display();
                }
            }
        }

        System.out.println(count);
    }
}
