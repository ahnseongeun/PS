package DataStructure.Brute_forece;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/*
8 8
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBBBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
 */
public class 체스판다시칠하기_1018 {
    static int compareBoard1[][];
    static int compareBoard2[][];
    private static int reColor(int col, int row, int[][] board) {
        int cnt1 = 0;
        int cnt2 = 0;
        //0출발
        for(int i = 0;i < 8;i++){
            for(int j = 0;j < 8;j++){
//                if(board[i+col][j+row]!=compareBoard1[i][j])
//                        cnt1++;
//                if(board[i+col][j+row]!=compareBoard2[i][j])
//                        cnt2++;
                int a = (i+j) % 2==0?0:1;
                int b = (i+j) % 2==0?1:0;
                if(board[i+col][j+row]==a)
                    cnt1++;
                if(board[i+col][j+row]==b)
                    cnt2++;
            }
        }
        //1출발
        return Math.min(cnt1, cnt2);
    }

//    private static void display(int[][] board) {
//        StringBuilder sb=new StringBuilder();
//        for(int i = 0;i< board.length;i++){
//            for(int j = 0; j < board[i].length;j++){
//                sb.append(board[i][j]+" ");
//            }
//            sb.append("\n");
//        }
//        System.out.println(sb);
//    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int board[][]=new int[n][m];
        compareBoard1 = new int[8][8];
        compareBoard2 = new int[8][8];
        for(int i = 0;i< n;i++){
            String str = input.readLine();
            for(int j = 0;j < m;j++) {
                if (str.charAt(j) == 'W') {// W = 0,B = 1
                    board[i][j] = 0;
                } else {
                    board[i][j] = 1;
                }
                if(i>7||j>7)
                    continue;
                compareBoard1[i][j] = (i+j) % 2;
                compareBoard2[i][j] = (i+j) % 2==0?1:0;
                /*
                굳이 compareBoard를 만들지 않고 reColor함수에서 배열을 비교 할 때
                (i+j) % 2==0?cnt1++:
                (i+j) % 2==0?:cnt2++
                 */
            }
        }
//        display(board);
//        display(compareBoard1);
//        display(compareBoard2);
        int min=100000;
        for(int i=0;i<=n-8;i++){
            for(int j=0;j<=m-8;j++){
                min = Math.min(min,reColor(i,j,board));
            }
        }
        System.out.println(min);
    }
}
