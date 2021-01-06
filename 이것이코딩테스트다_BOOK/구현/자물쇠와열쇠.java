package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 자물쇠와열쇠 {
    private static int[][] turnRight(int[][] key) {
        int size = key.length-1;
        int temp[][] = new int[size+1][size+1];
        for(int i=0;i<=size;i++){
            for(int j=0;j<=size;j++){
                if(i==j) {
                    temp[i][size-j]=key[i][j];
                }else if(i==j+1){

                }else{
                    temp[j][size - i] = key[i][j];
                }
            }
        }
        return key;
    }

    private static boolean openLock(int[][] key) {
        return false;
    }

    public static void main(String[] args) throws Exception{
        int key[][]={{0,0,0},
                     {1,0,0},
                     {0,1,1}};
        int lock[][]={{1,1,1},
                      {1,1,0},
                      {1,0,1}};
        boolean flag=false;
        for(int i=0;i<4;i++){
            if(openLock(key)) { //Lock이 열린다면
                flag=true;
            }else{ //Lock일 열리지 않는다면 90도 회전
                key=turnRight(key);
            }
        }
        System.out.println(flag);
    }
}
