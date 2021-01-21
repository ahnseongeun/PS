package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 소수구하기_1929 {
    private static boolean checkPrimeNumber(int num) {
        for(int i = 3;i <= Math.sqrt(num);i++){
            if(num % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        //소수는 영어 prime_number
        start = start==1 ? 2 : start;
        for(int i = start;i <= end; i++) {
            if(i == 2)
                sb.append(i).append("\n");

            if (i % 2 == 0)
                continue;

            if (checkPrimeNumber(i))
                sb.append(i).append("\n");
        }
        System.out.println(sb);
    }
}
