package 이것이코딩테스트다_BOOK.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 자물쇠와열쇠 {
    private static void display(int[][] temp){
        StringBuilder sb=new StringBuilder();
        int size= temp.length;
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                sb.append(temp[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
    private static int[][] turnRight(int[][] key) {
        int size=key.length;
        int temp[][]=new int[size][size];
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                temp[j][size-1-i]=key[i][j];
            }
        }
        return temp;
    }

    private static boolean openLock(int[][] key,int[][] padding) {
        int keySize= key.length-1;
        int result[][]=new int[padding.length][padding.length];

        for(int i=0;i<= padding.length-key.length;i++){ //padding 위치 설정
            for(int j=0;j<= padding.length-key.length;j++){

                for(int k=0;k<padding.length;k++) //깊은 복사로 result 배열 갱신
                    result[k]= Arrays.copyOf(padding[k],padding.length);

                for(int i1=0;i1<key.length;i1++){ //key값 위치 설정,임시적인 padding과 돌기와 홈을 비교
                    for(int j1=0;j1<key.length;j1++){
                        result[i+i1][j+j1]+=key[i1][j1];
                    }
                }
                if(check(result,keySize)) {
                    display(result);
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean check(int[][] result,int keySize) {
        for(int i=keySize;i<result.length-keySize;i++){
            for(int j=keySize;j< result.length-keySize;j++){
                if(result[i][j]!=1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        int key[][]={{0,0,0}, //0이 홈, 1이 돌기
                     {1,0,0},
                     {0,1,1}};
        int lock[][]={{1,1,1},
                      {1,1,0},
                      {1,0,1}};
        boolean flag=false;
        int size=lock.length+((key.length-1)*2);
        int padding[][]=new int[size][size];
        for(int i=0;i< padding.length;i++)
            Arrays.fill(padding[i],100);
        for(int i=0;i< lock.length;i++){
            for(int j=0;j< lock.length;j++){
                padding[i+ key.length-1][j+ key.length-1]=lock[i][j];
            }
        }
        display(padding);
        for(int i=0;i<4;i++){
            if(openLock(key,padding)) { //Lock이 열린다면
                flag=true;
            }else{ //Lock일 열리지 않는다면 90도 회전
                key=turnRight(key);
            }
        }
        System.out.println(flag);
    }
}
