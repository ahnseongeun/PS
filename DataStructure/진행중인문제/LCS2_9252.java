package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
ACAYKP
CAPCAK
 */
public class LCS2_9252 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str1 = input.readLine();
        String str2 = input.readLine();
        if(str2.length() > str1.length()){
            String str = str2;
            str2 = str1;
            str1 = str;
        }
        int dp[][] = new int[str2.length() + 1][str1.length() + 1];

        int max = -1;
        for(int i = 1; i <= str2.length(); i++){
            int ch = str2.charAt(i - 1);
            for(int j = 1; j <= str1.length(); j++){
                if(str1.charAt(j - 1) == ch){
                    if(Math.max(dp[i - 1][j],dp[i][j - 1]) + 1 > i )
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                    else
                        dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]) + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j],dp[i][j - 1]);
                }
                max = Math.max(max,dp[i][j]);
            }
        }
        //display(str1,str2,dp);
        sb.append(max + "\n");
        int cnt = 1;
        for(int i = 1; i <= str2.length(); i++){
            for(int j = 1; j <= str1.length(); j++){
                if(cnt > max)
                    break;
                if(dp[i][j] == cnt) {
                    sb.append(str1.charAt(j - 1));
                    cnt++;
                    break;
                }
            }
        }
        System.out.println(sb);
    }

    private static void display(String str1,String str2,int dp[][]) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= str2.length(); i++){
            for(int j = 1; j <= str1.length(); j++)
                sb.append(dp[i][j] + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
