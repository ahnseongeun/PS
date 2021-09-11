//import java.util.*;
//
//class Solution {
//
//    static int[] minInfo;
//    static boolean[] check;
//    static int result = -1;
//    static int[] answer;
//
//    static void dfs(int idx, int n, int sum, int[] info) {
//
//        if(sum == n) {
//            int lion_score = 0;
//            int apache_score = 0;
//            int score = 10;
//            for(int i = 0; i < 11; i++) {
//                //라이언이 점수 가져가기
//                if(check[i]) {
//                    lion_score += score;
//                } else {
//                    if(info[i] != 0) apache_score += score;
//                }
//                score--;
//            }
//
//            if(lion_score > apache_score) {
//                if(result <= lion_score - apache_score) {
//                    result = lion_score - apache_score;
//                    answer = new int[11];
//                    for(int i = 0; i < 11; i++) {
//                        if(check[i]) answer[i] = minInfo[i];
//                    }
//                }
//            }
//            return;
//        }
//
//        for(int i = 0; i < 11; i++) {
//
//            if(sum > n || check[i]) continue;
//            if(i == 10 &&  n < sum + minInfo[i] ) minInfo[i] = n - sum;
//            check[i] = true;
//            dfs(i, n, sum + minInfo[i], info);
//            check[i] = false;
//        }
//
//    }
//
//    public int[] solution(int n, int[] info) {
//
//        minInfo = new int[11];
//        check = new boolean[11];
//        for(int i = 0; i < minInfo.length; i++) {
//            minInfo[i] = info[i] + 1;
//        }
//
//        dfs(0, n, 0, info);
//
//        System.out.println(result);
//        if(result == -1) {
//            return new int[]{-1};
//        } else {
//            return answer;
//        }
//    }
//}