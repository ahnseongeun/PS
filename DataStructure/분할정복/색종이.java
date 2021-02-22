package DataStructure.분할정복;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 색종이 {
    static int arr[][];
    static int blueCount;
    static int whiteCount;

    private static void paintPaper(int start, int end, int size) {

        int var = arr[start][end];

        for(int i = start; i < start + size; i++){
            for(int j = end; j < end + size; j++){
                if(arr[i][j] != var){
                    int newSize = size / 2;
                    paintPaper(start ,end ,newSize);
                    paintPaper(start + newSize,end,newSize);
                    paintPaper(start,end + newSize,newSize);
                    paintPaper(start + newSize,end + newSize,newSize);
                    return;
                }
            }
        }
        if(var == 1){
            blueCount++;
        }else{
            whiteCount++;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        arr= new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        paintPaper(0,0,n);
        System.out.println(whiteCount);
        System.out.println(blueCount);
    }
}
