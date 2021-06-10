package DataStructure.다익스트라;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
3
0 1 0
0 0 1
1 0 0
 */
public class 경로찾기_11403 {

    private static void floyd(int[][] arr, int n) {

        for(int mid = 0; mid < arr.length; mid++){
            for(int start = 0; start < arr.length; start++){
                for(int target = 0; target < arr.length; target++){
                    if(arr[start][mid] == 1 && arr[mid][target] == 1)
                        arr[start][target] = 1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        int[][] arr = new int[n][n];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        floyd(arr,n);
    }
}
