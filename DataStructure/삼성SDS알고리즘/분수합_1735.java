package DataStructure.삼성SDS알고리즘;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 분수합_1735 {

    private static int gcd(int a, int b) {

        while(b != 0) {
            int r = a % b;
            a = b;
            b= r;
        }
        return a;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a1 = Integer.parseInt(st.nextToken());
        int a2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(input.readLine());
        int b1 = Integer.parseInt(st.nextToken());
        int b2 = Integer.parseInt(st.nextToken());
        int sum1 = a1 * b2 + a2 * b1;
        int sum2 = a2 * b2;
        int num = gcd(sum1, sum2);
        sum1 /= num;
        sum2 /= num;
        sb.append(sum1).append(" ").append(sum2);
        System.out.println(sb);
    }
}
