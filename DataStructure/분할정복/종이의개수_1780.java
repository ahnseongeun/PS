package DataStructure.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 재귀를 이용하는 문제였다.
 * 계속 9개의 분할이 발생하기 때문에 변수를 이용하기 보다는 3*3의 이중 포문을 만들고
 * 재귀를 실행시키는 함수에 알맞은 조건을 넣으면 되는 문제였다.
 */
public class 종이의개수_1780 {

    private static int minusCount = 0;
    private static int zeroCount = 0;
    private static int plusCount = 0;
    private static int[][] arr;

    private static void checkPaper(int start,int end,int size) {
        int var = arr[start][end];
        boolean flag = false;
        for(int i = start; i < start + size; i++){
            for(int j = end; j < end + size; j++){
                if(var != arr[i][j]){
                    flag = true;
                    break;
                }
            }
        }
        int newSize = size / 3;
        if(flag){
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    //System.out.println(start + (i * newSize) + " " + end + (j * newSize) + " " + newSize);
                    checkPaper(start + (i * newSize),end + (j * newSize), newSize); //start
                }
            }
        }else{
            if(var == 0)
                zeroCount++;
            if(var == -1)
                minusCount++;
            if(var == 1)
                plusCount++;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        arr= new int[n][n];
        for(int i = 0;i < n ; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        checkPaper(0,0,n);

        System.out.println(minusCount);
        System.out.println(zeroCount);
        System.out.println(plusCount);
    }
}
