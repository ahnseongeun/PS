package DataStructure.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class NQueen_9663 {
    private static int board[];
    private static int n;
    private static int result = 0;

    private static boolean check(int idx) {
        //y값으로 현재 x 값 찾는 것
        //범위를 idx 까지 해줘야 하는 이유는?
        //
        for(int i = 0; i < idx; i++){
            //세로 검사
            //if(i == idx)
            //    continue;
            if(board[i] == board[idx])
                return false;
            //대각선 검사
            if( Math.abs(idx - i) == Math.abs(board[idx] - board[i]) )
                return false;
        }
        return true;
    }

    private static void queen(int idx) {

        if(idx == n) {
            result ++;
            return;
        }

        for(int i = 0; i < n; i++){
            //들어갈 수 있는 지 검사
            board[idx] = i;
            if(check(idx)) {
                queen(idx + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        board = new int[n];
        Arrays.fill(board,-1);
        queen(0);
        System.out.println(result);
    }
}
