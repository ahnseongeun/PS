package CodingTest.삼성SDS입과테스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
4
1
5
4
1 2 8 9
4
1 2 5 10
5
1 2 3 4 5
 */

/**
 * N이 8
 * 1. 가장 빠른 사람이 나를 것이냐.
 * 2. 가장 빠른 2을 보내고 가장 느린 2명을 보내고 빠른 애를 다시 데려온다.
 */
public class Test1 {

    private static int getMinTime(int[] animal){

        int size = animal.length;
        int[] dp = new int[size];
        if(size == 1) return animal[0];
        dp[0] = animal[0];
        if(size == 2) return animal[1];
        dp[1] = animal[1];
        if(size == 3) return animal[0] + animal[1] + animal[2];
        dp[2] = animal[0] + animal[1] + animal[2];

        for(int i = 3; i < size; i++){
            //가장 빠른 사람이 나르는 경우
            int num1 = animal[0] * 2 + animal[i] + animal[i - 1] + dp[i - 2];
            //가장 빠른 두명을 보내고 데려오고 가장느린 2명 보내고 남은 빠른애를 데려온다.
            int num2 = animal[0] + animal[1] * 2 + animal[i] + dp[i - 2];
            dp[i] += Math.min(num1, num2);
        }

        return dp[size - 1];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 1; i <= n; i++){
            int m = Integer.parseInt(input.readLine());
            int[] animal = new int[m];

            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < m; j++)
                animal[j] = Integer.parseInt(st.nextToken());

            Arrays.sort(animal);
            sb.append("#").append(i).append(" ").append(getMinTime(animal)).append("\n");
        }
        System.out.println(sb);
    }
}
