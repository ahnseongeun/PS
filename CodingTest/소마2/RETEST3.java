package CodingTest.소마2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
재귀
4
1 3 4 5
6 2 9 9
4 3 10 5
5 2 8 6
34
 */
public class RETEST3 {

    private static int[][] arr;
    private static int n;
    private static int max = 0;
    private static int count = 0;
    private static int dy[][][][] = new int[33][33][33][33];

    /*
    왼쪽, 오른쪽에서 최대 값
     */
    private static int calSum1(int x, int y, int x_size, int y_size) {
        int result = 0;

        for(int i = y; i <= y_size ; i++){
            for(int j = x; j <= x_size ; j++){
                result = Math.max(arr[i][j],result);
            }
        }
        return result;
    }

    private static void searchMap1(int x, int y, int x_size, int y_size, int sum) {
        if(y == y_size && x == x_size){
            if(sum > max){
                max = sum;
            }
            return;
        }
        //왼쪽(오른쪽으로 재귀, sum은 왼쪽에서 최대 값)

        int su = calSum1(x,y,x_size / 2,y_size);
        searchMap1(x + x_size / 2, y, x_size / 2, y_size, sum + su);

        //위쪽(아래쪽으로 재귀, sum은 위쪽에서 최대 값)
        su = calSum1(x,y,x_size, y_size / 2);
        searchMap1(x, y + (y_size / 2), x_size, y_size / 2, sum + su);

        //오른쪽(왼쪽으로 재귀, sum은 오른쪽에서 최대 값)
        su = calSum1((x + x_size) / 2,y,x_size / 2, y_size);
        searchMap1(x,y,x_size / 2, y_size, sum + su);

        //아래쪽(위쪽으로 재귀, sum은 아래쪽에서 최대 값)
        su = calSum1(x, y + y_size / 2, x_size, y_size / 2);
        searchMap1(x,y,x_size,y_size/2,sum + su);

    }

    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(input.readLine());
        arr = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 1 ; j <= n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }

        }

        System.out.println(searchMap(1,n,1,n));
    }

    private static int searchMap(int y, int y_size, int x, int x_size) {
        //if(dy[y][y_size][x][x_size] != 0) return dy[y][y_size][x][x_size];
        if(y == y_size && x == x_size) {
            System.out.println(y);
            System.out.println(y_size);
            System.out.println(x);
            System.out.println(x_size);
            System.out.println("test");
            return 0;
        }

        int res = 0;

        //이 문제의 핵심은 재귀를 할 때 경계값을 어떻게 설정하는가 이다.
        //x == x_size라면 재귀를 멈춘다. , y == y_size라면 재귀를 멈춘다.
        //y값이 y_size와 같다는 의미가 무엇인가?? 시작과 끝이 같아서 더이상 재귀를 진행하면 안된다는 의미이다.
        if(y != y_size){ //y값이 y_size와 같다는 의미가 무엇인가??
            int m = (y + y_size) / 2;
            // 위쪽에서 최대 값 구하고 , 아래로 재귀
            res = Math.max(res, get_max(y, m , x, x_size) + searchMap(m + 1, y_size, x, x_size));
            // 아래쪽에서 최대 값 구하고, 위로 재귀
            res = Math.max(res, searchMap(y, m , x, x_size) + get_max(m + 1, y_size, x, x_size));
        }

        if(x != x_size){ //x값이 x_size와 같다는 의미가 무엇인가??
            int m = (x + x_size) / 2;
            // 왼쪽에서 최대 값 구하고, 오른쪽으로 재귀
            res = Math.max(res, get_max(y, y_size , x, m) + searchMap(y, y_size, m + 1, x_size));
            // 오른쪽에서 최대 값 구하고, 왼쪽으로 재귀
            res = Math.max(res, searchMap(y, y_size , x, m) + get_max(y, y_size, m + 1, x_size));
        }
        return res;
    }

    private static int get_max(int y, int y_size, int x, int x_size) {
        int res = 0;
        for(int i = y; i <= y_size ; i++)
            for(int j = x; j <= x_size ; j++)
                res = Math.max(res,arr[i][j]);
        return res;
    }
}
