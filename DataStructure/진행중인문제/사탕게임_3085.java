package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
4
PPPP
CYZY
CCPY
PPCC
 */
public class 사탕게임_3085 {
    static char[][] map;
    static int[] dx = {0, 0 , -1, 1}; //상, 하, 좌, 우
    static int[] dy = {-1, 1, 0, 0}; //상, 하, 좌, 우
    static int max = 0;

    static int getBomb(int y, int x, int n) {

        int result = 0;
        for(int i = 0; i < 4; i++) {
            int next_x = x + dx[i];
            int next_y = y + dy[i];
            if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= n || map[y][x] == map[next_y][next_x]) continue;
            swap(y, x, next_y, next_x);
            //System.out.println("before");
            //display(n);
            result = Math.max(result, getLength(n));
            swap(y, x, next_y, next_x);
            //display(n);
        }
        return result;
    }

    private static void display(int n) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void swap(int y, int x, int next_y, int next_x) {
        char temp = map[y][x];
        map[y][x] = map[next_y][next_x];
        map[next_y][next_x] = temp;
    }

    static int getLength(int n) {

        int length = 0;
        //행 값 구하기
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char ch = map[i][j];
                //하
                int cnt = 0;
                for(int k = i; k < n; k++) {
                    if(ch == map[k][j]) {
                        cnt++;
                        continue;
                    }
                    break;
                }
                length = Math.max(length, cnt);
                cnt = 0;
                //우
                for(int k = j; k < n; k++) {
                    if(ch == map[i][k]) {
                        cnt++;
                        continue;
                    }
                    break;
                }
                length = Math.max(length, cnt);
            }
        }
        return length;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        map = new char[n][n];
        for(int i = 0; i < n; i++) {
            String str = input.readLine();
            for(int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        max = getLength(n);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(max, getBomb(i, j, n));
            }
            if(max == n) break;
        }
        System.out.println(max);
    }
}
