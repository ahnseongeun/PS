package CodingTest.소마;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class test2 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int arr[][] = new int[p + 1][25];
        int arrCount[][] = new int[p + 1][25];
        for(int i = 0; i < n ; i++){
            st = new StringTokenizer(input.readLine());
            int num = Integer.parseInt(st.nextToken());
            int hour = Integer.parseInt(st.nextToken());
            arr[num][hour] = hour;
            arrCount[num][hour] += 1;
        }
        int sum = 0;
        for(int i = 1; i <= p; i++){
            Arrays.sort(arr[i]);
            sum = 0;
            for(int j = 0; j <= 24 ; j++){
                if(arr[i][j] == 0)
                    continue;
                int count = 0;
                while(arrCount[i][j] != count){
                    if(sum + arr[i][j] > h)
                        break;
                    sum += arr[i][j];
                    count++;
                }
                if(sum + arr[i][j] > h)
                    break;
            }
            sb.append(i + " " + sum*1000 +"\n");
        }
        System.out.println(sb);
    }
}
