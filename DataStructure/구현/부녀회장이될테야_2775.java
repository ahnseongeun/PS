package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
a = 1 , b = 3
0층 1 2 3

a = 2 , b = 3
1층 1 3 6
0층 1 2 3
 */
public class 부녀회장이될테야_2775 {
    static StringBuilder sb;

    private static void calculateCount(int a, int b) {
        int sum = 0;
        int person[][] = new int[a][b+1];

        for(int i = 0;i < a;i++){
            for(int j = 1;j <=b; j++){
                if(i == 0) {
                    person[i][j] = j;
                    continue;
                }
                for(int k = 1; k <= j;k++)
                    person[i][j] += person[i-1][k];
            }
        }
        for(int i = 1;i <= b;i++) {
            sum += person[a-1][i];
        }
        sb.append(sum+"\n");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(input.readLine());
        sb = new StringBuilder();
        for(int i = 0;i < t;i++){
            int a = Integer.parseInt(input.readLine());
            int b = Integer.parseInt(input.readLine());
            calculateCount(a,b);
        }
        System.out.println(sb);
    }
}
