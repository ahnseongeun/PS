package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3 1000 2 3
200
2 2 2
300
0 0 3
 */
public class 전국대학생프로그래밍대회동아리연합_5046 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int[] persons = new int[w];
        for(int i = 0; i < h; i++) {
            int price = Integer.parseInt(input.readLine());

            st = new StringTokenizer(input.readLine());
            for(int j = 0; j < w; j++) persons[j] = Integer.parseInt(st.nextToken());

            if( price * n > b) continue;

            for(int j = 0; j < w; j++) {
                if(persons[j] < n) continue;
                min = Math.min(min, n * price);
            }
        }

        System.out.println(min == Integer.MAX_VALUE ? "stay home" : min);
    }
}
