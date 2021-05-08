package CodingTest.카카오2021;

import java.util.HashMap;

class Test2 {

    private static int dx[] = {0,1,0,-1}; //상우하좌
    private static int dy[] = {-1,0,1,0};
    private static boolean checkDivide(int y, int x,int[][] map){

                //상,하,좌,우 검사
                for(int k = 0; k < 4; k++){
                    int next_y = y;
                    int next_x = x;
                    for(int l = 0; l < 2; l++){
                        next_x += dx[k];
                        next_y += dy[k];
                        if(next_x < 0 || next_y < 0 || next_x >= 5 || next_y >= 5)
                            break;
                        if(map[next_y][next_x] == 1)
                            break;
                        if(map[next_y][next_x] == 2) {
                            return false;
                        }
                    }
                }
                //대각선 검사
                for(int i = 0; i < 4; i++){
                    int next_x = x + dx[i] + dx[(i + 1) % 4];
                    int next_y = y + dy[i] + dy[(i + 1) % 4];
                    if(next_x < 0 || next_y < 0 || next_x >= 5 || next_y >= 5)
                        continue;
                    if(map[next_y][next_x] == 2 ){
                        if(map[y + dy[i]][x + dx[i]] != 1 || map[y + dy[(i + 1) % 4]][x + dx[(i + 1) % 4]] != 1)
                            return false;
                    }
                }
        return true;
    }

    private static int check(String[] places){
        int[][] map = new int[5][5];

        for(int i = 0; i < 5; i++){
            String str = places[i];
            for(int j = 0; j < 5; j++){
                char ch = str.charAt(j);
                //응시자 2
                if(ch == 'P'){
                    map[i][j] = 2;
                    //파티션 1
                }else if(ch == 'X'){
                    map[i][j] = 1;
                    //빈테이블 0
                }else{
                    map[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                if(map[i][j] == 2){
                    if(!checkDivide(i,j,map)) //거리두기를 하고 있으면(true)면 통과
                        return 0;
                }
            }
        }


        //만족시키면
        return 1;
    }


    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i = 0 ; i < places.length; i++){
            answer[i] = check(places[i]);
        }
        return answer;
    }
}