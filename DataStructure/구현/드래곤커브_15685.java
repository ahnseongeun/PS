package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
3
3 3 0 1
4 2 1 3
4 2 2 1
0: x좌표가 증가하는 방향 (→)
1: y좌표가 감소하는 방향 (↑)
2: x좌표가 감소하는 방향 (←)
3: y좌표가 증가하는 방향 (↓)
 */

/**
 * 규칙을 찾는 방법
 * 첫번재는 회전 변환을 생각했다. 하지만 방향의 규칙을 찾았다면 더 쉽게 해결 할 수 있는 문제였다.
 * 이전 세대의 규칙을 뒤짚고 + 1씩 해주면 그것이 다음 세대의 규칙이다.
 * 1. 모든 방향의 규칙을 찾는다.
 * 2. 규칙을 이용해서 지도에 좌표를 표시한다.
 * 3. 사각형의 개수를 출력한다.
 */
public class 드래곤커브_15685 {

    private static boolean board[][];
    private static List<Integer> direction_list;
    private static int g = 0;
    private static int dx[] = {1, 0, -1, 0}; //우 상 좌 하
    private static int dy[] = {0, -1, 0, 1};

    private static void curve(int level) {

        //level이 g라면 그만
        if(level == g){
            return;
        }

        for(int i = direction_list.size() - 1; i >= 0; i--){
            direction_list.add( (direction_list.get(i) + 1) % 4 );
        }

        curve(level + 1);

    }

    private static int calCount(boolean[][] board) {

        int count = 0;

        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(board[i][j] && board[i][j + 1] && board[i + 1][j] && board[i + 1][j + 1])
                    count++;
            }
        }
        return count;
    }

    private static void drawMap(int x, int y) {
        board[y][x] = true;
        for(int direction : direction_list){
            x = x + dx[direction];
            y = y + dy[direction];
            board[y][x] = true;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        board = new boolean[101][101];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int x = Integer.parseInt(st.nextToken()); // x 좌표
            int y = Integer.parseInt(st.nextToken()); // y 좌표
            int d = Integer.parseInt(st.nextToken()); // d 시작 방향
            g = Integer.parseInt(st.nextToken()); // g 세대
            direction_list = new ArrayList<>();
            direction_list.add(d);
            curve(0);
            drawMap(x, y);
        }
        System.out.println(calCount(board));
    }


}
