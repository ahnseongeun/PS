package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
6
3
3 4
2 5
5 3
3
3 D
15 L
17 D
 */

/**
 * 방향 전환한 위치를 기억해 두자.
 * 방향 전화를 어떻게 표시하고 어떻게 이용할 것인가
 * 꼬리가 방향을 틀면 방향전환 표시를 해제하는 방식
 */
public class 뱀 {
    static int tailboard[][];

//    private static void display(int board[][]){
//        int size= board.length;
//        StringBuilder sb=new StringBuilder();
//        for(int i=1;i<size;i++){
//            for(int j=1;j<size;j++){
//                sb.append(board[i][j]+" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    private static int startGame(int[][] board, HashMap<Integer, Character> command) {
        int time=0;
        int wall=board.length;
        int head_x=1,head_y=1;
        int tail_x=1,tail_y=1;
        int dx[]={0,1,0,-1};
        int dy[]={-1,0,1,0};
        int direction=1;//0은 위,1은 오른쪽,2는 아래,3은 왼쪽
        int tail_direction=1;
        board[head_y][head_x]=1;
        //0은 비어있는 곳, 1은 현재 뱀, 2는 사과의 위치

        while(true){
            time++;
            //사과를 먹었을 경우도 고려
            head_x+=dx[direction];
            head_y+=dy[direction];
            if(head_x==0||head_y==0||head_x==wall||head_y==wall||board[head_y][head_x]==1) {
                break;
            }

            if(board[head_y][head_x]==0){ //비어있는곳 그래서 전진
                board[head_y][head_x]=1;
                board[tail_y][tail_x]=0; //보여지는 꼬리 부분은 0
                //꼬리 부분 방향 전환에 기록되어 있으면 턴하기
                if(tailboard[tail_y][tail_x]!=-1) {
                    tail_direction = tailboard[tail_y][tail_x];
                    tailboard[tail_y][tail_x]=-1;
                }
                tail_x += dx[tail_direction];
                tail_y += dy[tail_direction];
            }else{ //사과의 위치여서 뱀의 크기를 키우기
                board[head_y][head_x]=1;
            }

            if(command.get(time)!=null){
                //턴하기
                if(command.get(time)=='D'){
                    direction=direction+1;
                    if(direction==4)
                        direction=0;
                }else{
                    direction=direction-1;
                    if(direction==-1)
                        direction=3;
                }
                tailboard[head_y][head_x]=direction; //방향 기록 board에 방향 저장
            }
//            display(board);
//            System.out.println();
//            display(tailboard);
        }
        return time;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int board[][]=new int[n+1][n+1];
        tailboard=new int[n+1][n+1];
        for(int i=0;i< tailboard.length;i++)
            Arrays.fill(tailboard[i],-1);

        int appleCount=Integer.parseInt(input.readLine());
        StringTokenizer st;
        for(int i=0;i<appleCount;i++){
            st=new StringTokenizer(input.readLine());
            int apple_y=Integer.parseInt(st.nextToken());
            int apple_x=Integer.parseInt(st.nextToken());
            board[apple_y][apple_x]=2; //사과
        }
        HashMap<Integer,Character> command=new HashMap<>();
        int commandSize=Integer.parseInt(input.readLine());
        for(int i=0;i<commandSize;i++){
            st=new StringTokenizer(input.readLine());
            int num=Integer.parseInt(st.nextToken());
            char com=st.nextToken().charAt(0);
            command.put(num,com);
        }
        System.out.println(startGame(board,command));
    }
}
