package DataStructure.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 쿼드트리_1992 {
    private static int arr[][];
    private static StringBuilder sb;

    private static boolean checkCompress(int start, int end, int n) {
        int var = arr[start][end];

        for(int i = start; i < start + n; i++){
            for(int j = end; j < end + n; j++){
                if(var != arr[i][j]){
                    return false;
                }
            }
        }
        sb.append(var);
        return true;
    }

    private static void videoCompress(int start, int end, int n) {

        if(!checkCompress(start, end, n)){
            sb.append("(");
            videoCompress(start, end , n/2);
            videoCompress(start, end + n/2, n/2);
            videoCompress(start + n/2, end , n/2);
            videoCompress(start + n/2, end + n/2, n/2);
            sb.append(")");
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        sb = new StringBuilder();
        arr= new int[n][n];

        for(int i = 0 ; i < n; i++){
            String str = input.readLine();
            for(int j = 0; j < n; j++){
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        videoCompress(0,0,n);
        System.out.println(sb);
    }

}
