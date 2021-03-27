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
 */
public class TEST3 {

    private static int arr[][];
    private static int max;
    private static int n;

    private static int calculationSum(int y, int x , int y_size, int x_size) {
        int result = 0;
        for(int i = y; i < y_size; i++)
            for(int j = x; j < x_size; j++)
                result = Math.max(result,arr[i][j]);
        return result;
    }

    private static void maxBenefit(int y, int x, int y_size, int x_size, int sum) {
        if(x < 0 || y < 0 || x >= n || y >= n || x_size < 1 || y_size < 1) {
            System.out.println(y + " " + x);
            max = Math.max(max,sum + arr[y][x]);
            System.out.println(max);
            return;
        }
//        if(y_size < 1 || x_size < 1) {
//            System.out.println(y + " " + x);
//            max = Math.max(max,sum + arr[y][x]);
//            System.out.println(max);
//            return;
//        }

        //왼쪽
        //y, x + (x_size / 2),y_size ,x_size / 2
        //cal은 왼쪽 , 새로운것은 오른쪽
        //System.out.println(y+" "+x);
        maxBenefit(y, x + (x_size / 2), y_size ,x_size / 2,sum + calculationSum(y, x ,y_size,x + x_size / 2));

        //위쪽
        //cal은 위쪽 , 새로운것은 아래쪽
        //y / 2, x  , y + (y_size / 2), x_size
        maxBenefit(y , x  , (y_size / 2), x_size,sum + calculationSum(y , x ,y_size / 2,x_size));

        //오른쪽
        //cal은 오른쪽 , 새로운것은 왼쪽
        //y , x , y_size, x_size / 2
        maxBenefit(y , x  , y_size, x_size / 2 ,sum + calculationSum(y, x + (x_size / 2), y_size,x + x_size / 2));

        //아래쪽
        //cal은 아래쪽 , 새로운것은 위쪽
        //y , x, y_size / 2, x_size
        maxBenefit(y + (y_size / 2), x, y_size / 2, x_size,sum + calculationSum(y + (y_size / 2), x ,y + (y_size / 2),x_size));
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        max = 0;
        maxBenefit(0,0, n, n, 0);
        System.out.println(max);
    }
}