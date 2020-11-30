package HackerRanker;

import java.util.Scanner;

public class Day11 {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        int[][] arr = new int[6][6];

        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }

        }
        int max = Integer.MIN_VALUE;
        int sum;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                sum=0;
                for(int n=i;n<i+3;n++){
                    for(int m=j;m<j+3;m++){
                        if(n==i+1&&m==j||n==i+1&&m==j+2)
                            continue;
                        sum+=arr[n][m];
                    }
                }
                max=Math.max(max,sum);
            }
        }
        System.out.println(max);
        scanner.close();
    }
}
