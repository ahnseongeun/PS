package DataStructure.bronze;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
5
1 6
3 7
6 2
7 100
9 635
 */
public class 분산처리_1009 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = 1;
            for(int j = 0; j < b; j++) {
                c = c * a % 10;
            }
        }
        System.out.println(sb);
    }
}
