package DataStructure.진행중인문제;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
9
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
0 0 0 1 1 1 -1 -1 -1
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
1 1 1 0 0 0 0 0 0
0 1 -1 0 1 -1 0 1 -1
0 -1 1 0 1 -1 0 1 -1
0 1 -1 1 0 -1 0 1 -1
 */
public class 종이의개수1_1780 {
    private static int count1 = 0; //-1
    private static int count2 = 0; //0
    private static int count3 = 0; //1

    private static void getPaperCount(int x, int y, int size, int[][] arr) {
        //검사
        int val = arr[y][x];
        boolean flag = false;
        for(int i = y; i < y + size; i++){
            for(int j = x; j < x + size; j++){
                if(val != arr[i][j]){
                    flag = true;
                    break;
                }
            }
        }
        if(flag){
            if(val == -1) count1++;
            if(val == 0) count2++;
            if(val == 1) count3++;
            return;
        }
        int newSize = size / 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                //각 사이즈 별로 재귀
                getPaperCount(x + (i * newSize),y + (j * newSize), newSize, arr);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        int[][] arr = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getPaperCount(0,0,n,arr);
        sb.append(count1).append("\n");
        sb.append(count2).append("\n");
        sb.append(count3).append("\n");
        System.out.println(sb);
    }
}
