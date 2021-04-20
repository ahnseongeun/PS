package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
CAPCAK
ACAYKP
최장 공통 부분 수열
 */
/**
 * dp[i][j] = 두 문자가 같다면 dp[i - 1][j] + 1, 두 문자가 다르다면 dp[i - 1][j]
 */
public class LCS_9251 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str1 = input.readLine();
        String str2 = input.readLine();
//        if(str1.length() > str2.length()) {
//            String str3 = str2;
//            str2 = str1;
//            str1 = str3;
//        }
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];

        int max = 0;
        for(int i = 1; i <= str1.length(); i++){
            for(int j = 1; j <= str2.length(); j++){
                if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                    //dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j] + 1);
                    //이곳을 최소값으로 해줘야하는 이유는? 그럼 이건?? 왜 최소인데??
                    //2차원 배열이기 때문에 하나의 행에는 최대 + 1까지 만 허용된다.
                    dp[i][j] = Math.min(dp[i][j - 1],dp[i - 1][j]) + 1;
                }else{
                    //이곳을 최대값으로 해줘야하는 이유는? 여태까지 것중에 최대
                    dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]);
                }
                sb.append(dp[i][j]).append(" ");
                max = Math.max(max,dp[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
        System.out.println(max);


    }
}
