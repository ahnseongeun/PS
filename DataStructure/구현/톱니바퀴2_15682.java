package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.StringTokenizer;


/**
 * 첫째 줄에 톱니바퀴의 개수 T (1 ≤ T ≤ 1,000)가 주어진다.
 *
 * 둘째 줄부터 T개의 줄에 톱니바퀴의 상태가 가장 왼쪽 톱니바퀴부터 순서대로 주어진다.
 * 상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서대로 주어진다. N극은 0, S극은 1로 나타나있다.
 *
 * 다음 줄에는 회전 횟수 K(1 ≤ K ≤ 1,000)가 주어진다. 다음 K개 줄에는 회전시킨 방법이 순서대로 주어진다.
 * 각 방법은 두 개의 정수로 이루어져 있고, 첫 번째 정수는 회전시킨 톱니바퀴의 번호, 두 번째 정수는 방향이다.
 * 방향이 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향이다.
 * N 0, S 1
 * 시계 방향 1, 반시계 방향 -1
 */
/*
4
11111111
11111111
11111111
11111111
3
1 1
2 1
3 1
 */
public class 톱니바퀴2_15682 {

    private static int n;
    private static char[][] wheel;
    private static int[] directionCheck;

    private static void moveWheel(int wheelNum, int wheelDir) {

        directionCheck[wheelNum] = wheelDir;

        int left = wheelNum;
        int leftDir = wheelDir;
        int right = wheelNum;
        int rightDir = wheelDir;

        //왼쪽
        while(left > 0){
            if(wheel[left - 1][2] == wheel[left][6])
                break;
            leftDir = -leftDir;
            directionCheck[left - 1] = leftDir;
            left--;
        }

        //오른쪽
        while(right < n - 1){
            if(wheel[right][2] == wheel[right + 1][6])
                break;
            rightDir = -rightDir;
            directionCheck[right + 1] = rightDir;
            right++;
        }

        //바퀴 회전
        for(int i = 0; i < n; i++){
            char[] arr = new char[8];
            if(directionCheck[i] == 1){ //정방향 회전

                for(int j = 0; j < 8; j++){
                    arr[j] = wheel[i][j];
                }
                for(int j = 0; j < 8; j++){
                    wheel[i][(j + 1 + 8) % 8] = arr[j];
                }
            }else if(directionCheck[i] == 0){

            }else{ //역방향 회전

                for(int j = 0; j < 8; j++){
                    arr[j] = wheel[i][j];
                }
                for(int j = 0; j < 8; j++){
                    wheel[i][(j - 1 + 8) % 8] = arr[j];
                }
            }
        }

    }

    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        wheel = new char[n][8];

        for(int i = 0; i < n; i++)
            wheel[i] = input.readLine().toCharArray();

        int m = Integer.parseInt(input.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int wheelNum = Integer.parseInt(st.nextToken());
            int wheelDir = Integer.parseInt(st.nextToken());
            directionCheck = new int[n];
            moveWheel(wheelNum - 1, wheelDir);
        }
        int count = 0;
        for(int i = 0; i < n ; i++)
            if(wheel[i][0] == '1')
                count++;
        System.out.println(count);
    }
}
