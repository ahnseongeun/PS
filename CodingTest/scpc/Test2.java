package CodingTest.scpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


/**
 *     1. 초기에 bi (1≤i≤n) 는 모두 0으로 리셋한다.
 *     2. 만약  i>t 이고 ai−t=1 이면 bi는 1로 둔다.
 *     3. 만약  i≤n−t 이고 ai+t=1 이면 bi 는 1로 둔다.
 */
/*
2
5 1
00111
10 2
1111111000
 */
public class Test2 {

    private static int getTransform(int len, int t, String bits) {
        return 1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for( int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int len = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            String bits = input.readLine();
            sb.append("Case #").append(i + 1).append(" ").append("\n").append(getTransform(len, t, bits)).append("\n");
        }
    }
}
