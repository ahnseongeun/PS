package DataStructure.DP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
3
11
16
12
 */
public class 생일수_11883 {

    private static void calHolidayNumber(int[] number,int[] dp) {

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        dp[0] = -1;
        while(!q.isEmpty()){
            int val = q.poll();
            if(val > 1000000) continue;
            for(int i = 0; i < 3; i++){
                if(dp[val] == 0) continue;
                if(dp[val + number[i]] == 0) {
                    dp[val + number[i]] = number[i];
                    q.add(val + number[i]);
                }
            }
        }
    }

    private static String backtracking(int val, int[] dp) {
        StringBuilder sb = new StringBuilder();
        if(dp[val] == 0) return "-1";
        while(val != 0){
            sb.append(dp[val]);
            val -= dp[val];
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        int[] number = {3, 5, 8};
        int[] dp = new int[1000010];
        calHolidayNumber(number,dp);
        for(int i = 0; i < n; i++){
            int val = Integer.parseInt(input.readLine());
            sb.append(backtracking(val,dp)).append("\n");
        }
        System.out.println(sb);
    }
}
