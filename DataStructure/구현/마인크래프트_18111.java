package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 나의 잘못된 접근법
 * 처음에 그리디 방법으로 접근을 했다.
 * 블록을 없애는 것과 블록을 채우는 것중 더 시간이 적게 걸리는 것으로 접근하는 것이 맞다고 생각했다.
 * 하지만 매순간 두가지 경우중 한가지 못하기 때문에 최대 2 * 256 * 500 * 500의 시간이 걸리고 결국 시간초과가 날 것이다.
 * 그래서 0 ~ 256층 까지 층을 기준으로 얼마나 시간이 걸리는지를 구하는 방법이 없애는 것과 채우는 것을 동시에 진행할수 있게하고
 * 256 * 500 * 500으로 더 확실하고 올바른 방법이라는 것을 깨달았다.
 */
public class 마인크래프트_18111 {

     /**
     * 제거가 2초
     * 쌓는 것이 1초
     */
    private static int searchHeight(int floor, int n,int m,int b,int[][] arr) {
        int totalTime = 0;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(floor > arr[i][j]){ //floor가 더 크다면 쌓기를 진행하자
                    int time = floor - arr[i][j];
                    totalTime += time;
                    b -= time;
                }else if(floor == arr[i][j]){
                    continue;
                }else{ //floor가 더 작다면 삭제를 진행하자
                    int time = (arr[i][j] - floor);
                    totalTime += (time * 2);
                    b += time;
                }
            }
        }
        if(b < 0)
            return -1;
        return totalTime;
    }



    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n][m];
        int max = -1;
        for(int i = 0;i < n; i++){
            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m; j++){
                int var = Integer.parseInt(st.nextToken());
                max = Math.max(var,max);
                arr[i][j] = var;
            }
        }

        int min = Integer.MAX_VALUE;
        int height = -1;
        for(int i = 0 ; i <= max ; i++){
            int compare = searchHeight(i,n,m,b,arr);
            if(compare != -1 && min >= compare){
                min = compare;
                height = i;
            }
        }

        System.out.println(min + " " + height);
    }
}
