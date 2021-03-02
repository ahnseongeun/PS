package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 주사위굴리기_14499 {

    private static int n;
    private static int m;
    private static int x;
    private static int y;
    private static int arr[][];
    private static int dice[];
    private static int command[];

    private static void simulation(int c) {

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < c; i++){
            int cmd = command[i];
            int result = 0;
            if(cmd == 1){ //동
                result = moveRight();
            }else if(cmd == 2){ //서
                result = moveLeft();
            }else if(cmd == 3){ //북
                result = moveUp();
            }else{ //남
                result = moveDown();
            }
            if(result == -1)
                continue;
            else {
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static int moveUp() {
        int next_x = x;
        int next_y = y - 1;

        if(next_y < 0){ //한바퀴 구르기만
            return -1;
        }else{ //바닥의 수 고려
            x = next_x;
            y = next_y;
            if(arr[next_y][next_x] == 0){
                arr[next_y][next_x] = dice[3];
            }else{
                dice[3] = arr[next_y][next_x];
                arr[next_y][next_x] = 0;
            }
            //0 -> 3, 3 -> 5 , 5 -> 1 , 1 -> 0
            int dice1 = dice[0];
            int dice2 = dice[3];
            int dice3 = dice[5];
            int dice4 = dice[1];
            dice[3] = dice1;
            dice[5] = dice2;
            dice[1] = dice3;
            dice[0] = dice4;
            return dice[0];
        }
    }

    //0 -> 2, 2 -> 5 , 5 -> 4 , 4 -> 0
    private static int moveLeft() {
        int next_x = x - 1;
        int next_y = y;

        if(next_x < 0){ //한바퀴 구르기만
            return -1;
        }else{ //바닥의 수 고려
            x = next_x;
            y = next_y;
            if(arr[next_y][next_x] == 0){
                arr[next_y][next_x] = dice[2];
            }else{
                dice[2] = arr[next_y][next_x];
                arr[next_y][next_x] = 0;
            }
            //0 -> 2, 2 -> 5 , 5 -> 4 , 4 -> 0
            int dice1 = dice[0];
            int dice2 = dice[2];
            int dice3 = dice[5];
            int dice4 = dice[4];
            dice[2] = dice1;
            dice[5] = dice2;
            dice[4] = dice3;
            dice[0] = dice4;
            return dice[0];
        }
    }


    //0 -> 1, 1 -> 5 , 5 -> 3 , 3 -> 0
    private static int moveDown() {
        int next_x = x;
        int next_y = y + 1;

        if(next_y >= n){ //한바퀴 구르기만
            return -1;
        }else{ //바닥의 수 고려
            x = next_x;
            y = next_y;
            if(arr[next_y][next_x] == 0){
                arr[next_y][next_x] = dice[1];
            }else{
                dice[1] = arr[next_y][next_x];
                arr[next_y][next_x] = 0;
            }
            int dice1 = dice[0];
            int dice2 = dice[1];
            int dice3 = dice[5];
            int dice4 = dice[3];
            dice[1] = dice1;
            dice[5] = dice2;
            dice[3] = dice3;
            dice[0] = dice4;
            return dice[0];
        }
    }

    //0 -> 4, 4 -> 5 , 5 -> 2 , 2 -> 0
    private static int moveRight() {

        int next_x = x + 1;
        int next_y = y;

        if(next_x >= m){ //한바퀴 구르기만
            return -1;
        }else{ //바닥의 수 고려
            x = next_x;
            y = next_y;
            if(arr[next_y][next_x] == 0){
                arr[next_y][next_x] = dice[4];
            }else{
                dice[4] = arr[next_y][next_x];
                arr[next_y][next_x] = 0;
            }
            int dice1 = dice[0];
            int dice2 = dice[4];
            int dice3 = dice[5];
            int dice4 = dice[2];
            dice[4] = dice1;
            dice[5] = dice2;
            dice[2] = dice3;
            dice[0] = dice4;
            return dice[0];
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        command = new int[c];
        dice = new int[6]; // 1,2,3,4,5,6

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < c;i++)
            command[i] = Integer.parseInt(st.nextToken());

        simulation(c);
    }
}
