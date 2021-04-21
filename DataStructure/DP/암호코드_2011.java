package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

/**
 * A 1 , Z 26
 * 25114 -> 해석의 총 경우의 수
 * 한 자리 또는 두 자리 비교 가능
 * 이것이 왜 dp로 풀어야하는가? 무엇을 기준으로 dp를 만들 것인가?
 * 5000자리 이하, 즉, 최대 5000자리 까지 가능인데 그럼 최악의 경우의 수는 완전탐색이 안되는 이유는?
 * 5000 * 5000은 25000000
 * 백만개의 데이터는 4MB -> 128 3천 2백만의 데이터까지 저장 가능
 * 각 자리수 마다 총 경우의 수를 저장한다. 어떻게 곱셈으로
 * 내가 생각하지 못한 반례 30, 100
 */
public class 암호코드_2011 {

    private static long dp[];
    private static HashMap<Integer,Character> map;
    private static char[] chars;

    //한자리의 경우와 두자리의 경우를 더 해준다.
    private static long search() {

        int max = 0;
        for(int i = 1; i < chars.length; i++){

            //한자리일 경우 && 한자리일 경우 0일 때 생략하고 두자리 일 경우까지 검사
            if(chars[i] != '0')
                dp[i] = dp[i - 1];
            //System.out.println(dp[i]);
            //왜 dp[i] += dp[i - 1]처럼 +를 해줘야 하는가?? 어차피 dp[i]는 항상 0 아닌가?

            if(i == 1)
                continue;
            //두자리일 경우
            StringBuilder sb = new StringBuilder();
            int num = Integer.parseInt(String.valueOf(sb.append(chars[i - 1]).append(chars[i])));
            if(map.get(num) != null) {
                dp[i] = (dp[i] + dp[i - 2]) % 1000000;
            }

        }

        return dp[chars.length - 1];
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String str = input.readLine();

        map = new HashMap<>();
        for(int i = 10; i <= 26; i++ )
            map.put(i, (char) ('A' + i - 1));

        dp = new long[str.length() + 1];
        chars = new char[str.length() + 1];
        for(int i = 0; i < str.length(); i++)
            chars[i + 1] = str.charAt(i);
        dp[0] = 1;
        if(str.charAt(0) == '0' || str.length() == 0)
            System.out.println(0);
        else
            System.out.println( search() );

        //StringBuilder sb = new StringBuilder();
        //Arrays.stream(dp).forEach(value -> sb.append(value+ " "));
        //System.out.println(sb);
    }
}
