package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
/*
4 4
1 1 0
0 0 0 0
0 0 0 0
0 0 0 0
0 0 0 0
 */

/**
 * 구현 문제
 * 1. 상하좌우 갈수 있는곳 탐색
 * 2. 이동 후 1번 다시 반복
 * 3. 갈수 있는 곳이 없으면 뒤로 후진후 1번 반복
 * 4. 갈수 있는 곳이 없고 뒤로 가는 곳이 바다면 움직임 정지
 */
public class 게임게발 {

    static boolean visited[][];
    static int dx[]={0,1,0,-1}; //상우하좌
    static int dy[]={-1,0,1,0};
    static int direction[]={0,1,2,3};//북,동,남,서

    private static void display(){
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<visited.length;i++){
            for(int j=0;j< visited.length;j++){
                sb.append(visited[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static void direction(int x, int y, int d, int[][] map) {
        int next_x=0;
        int next_y=0;
        int present_d=d;
        int count=1;
        int turn_count=0;
        int size=map.length-1;
        visited[y][x]=true;
        while(true){
            for(int i=0;i<4;i++){
                present_d=(present_d+3)%4; //turn_left
                next_x=x+dx[direction[present_d]];
                next_y=y+dy[direction[present_d]];
                //System.out.println(next_x+" "+next_y);
                if(next_x<0||next_x>size||next_y<0||next_y>size||visited[next_y][next_x]) {
                    turn_count++;
                    continue;
                }
                x=next_x;
                y=next_y;
                visited[y][x]=true;
                count++;
                break;
            }
//            if(turn_count==4) {
//                System.out.println(x+""+y);
//                //display();
//            }
            if(turn_count==4){ //한칸 뒤로
                x-=dx[direction[present_d]];
                y-=dy[direction[present_d]];
                if(x<0||x>size||y<0||y>size||map[y][x]==1) {
                    break;
                }
            }
//            System.out.println(x+""+y);
            display();
            turn_count=0;
        }
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int map[][]=new int[n][m];
        visited=new boolean[n][m];

        st=new StringTokenizer(input.readLine());
        int x=Integer.parseInt(st.nextToken());
        int y=Integer.parseInt(st.nextToken());
        int d=Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st= new StringTokenizer(input.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j]==1)
                    visited[i][j]=true;
            }
        }
        direction(x,y,d,map);
    }
}
