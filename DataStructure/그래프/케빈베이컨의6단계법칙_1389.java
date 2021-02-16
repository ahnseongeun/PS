package DataStructure.그래프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 케빈베이컨의6단계법칙_1389 {

    private static void floyd(int start, int n, int[][] arr) {
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                arr[i][j] = Math.min(arr[i][j],arr[i][start]+arr[start][j]);
            }
        }
    }

    private static int display(int[][] arr,int n) {
        int result = 0;
        int min = 1000000;

        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <=n ;j++){
                sum += arr[i][j];
            }
            if(min > sum){
                min = sum;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken()); //유저 수
        int m = Integer.parseInt(st.nextToken()); //관계 수
        int arr[][] = new int[n+1][n+1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(arr[i],10000000);
            arr[i][i] = 0;
        }
        for(int i = 0; i < m ;i++){
            st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        int min = 10000000;
        int idx = 0;
        for(int i = 1; i <= n;i++) { //start 유저
            floyd(i,n,arr);
        }
        System.out.println(display(arr,n));
    }
}
