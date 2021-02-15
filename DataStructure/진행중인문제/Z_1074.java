package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 첫번째 접근은 2차원 배열을 이용한 분할정복 -> 메모리 초과
 * 두번째 접근은 count++을 이용한 분할정복 -> 시간초과
 * 그럼 count++을 하지 않고 수학적으로 접근해서 해당 인덱스로 바로 접근하는 방법을 사용해야한다.
 */
public class Z_1074 {
    static int r;
    static int c;

    private static void fillArray(int n, int i, int j, int idx) {
        /**
         * r c 가 4 1 일때
         *
         */
        if(i > r || j > c || i + n <= r || j + n <= c )
            return;

        if(n == 2){
            if(i == r && j == c){
                System.out.println(idx);
                System.exit(0);
            }
            if(i == r && j+1 == c){
                System.out.println(idx+1);
                System.exit(0);
            }
            if(i+1 == r && j == c){
                System.out.println(idx+2);
                System.exit(0);
            }
            if(i+1 == r && j+1 == c){
                System.out.println(idx+3);
                System.exit(0);
            }
            return;
        }

        int size = n/2;
        fillArray(size,i,j,idx);
        fillArray(size,i,j+size,idx+(size*size));
        fillArray(size,i+size,j,idx+(size*size)*2);
        fillArray(size,i+size,j+size,idx+(size*size)*3);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = (int) Math.pow(2,a);
        fillArray(n,0,0,0);
    }
}
