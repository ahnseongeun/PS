package DataStructure.문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
abcxyzxabc
2
abc 10
xyz 5
abcaxyzbc
2
abc 100
xyz 1
 */

/**
 * 삭제 연산은 두 가지 방법이 존재하며, 원하는 만큼 여러 번에 걸쳐서 수행할 수 있다.
 * 1. 문자열 의 부분 문자열 중에 문자열  가 존재한다면 해당하는 부분을 지우고  만큼의 점수를 얻는다(여러 부분 존재해도 한 번만 지운다).
 * 2. 문자열 에서 문자 하나를 지우고 점수를 점을 얻을 수 있다.
 * 문자열을 삭제하고 빈 부분을 메꾸는 방식이 아닌 놔두는 방식이다. -> 문자열을 지우고 합치는 경우는 생각안해도 된다.
 * -> 지우는 방식이 아닌 인덱스로 검사하는 방식으로 진행해야한다.
 */
public class 문자열제거_21941 {

    private static String str;
    private static int n;
    private static int[] dp;
    private static HashMap<String,Integer> map;


    private static int dfs(int index) {

        if(index >= str.length()) return 0;
        if(dp[index] != 0) return dp[index];
        int maxValue = 0;

        //문자열 의 부분 문자열 중에 문자열  가 존재한다면 해당하는 부분을 지우고  만큼의 점수를 얻는다(여러 부분 존재해도 한 번만 지운다).
        //한번만 지운다 -> 앞에꺼 부터 지운다.
        for( String key : map.keySet()) {
            int score = map.get(key);
            if(str.startsWith(key, index))
                maxValue = Math.max(maxValue, dfs(index + key.length()) + score);
        }
        //문자열 에서 문자 하나를 지우고 점수를 점을 얻을 수 있다.
        dp[index] = Math.max(maxValue, dfs(index + 1) + 1);
        return dp[index];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        str = input.readLine();
        n = Integer.parseInt(input.readLine());
        map = new HashMap<>();
        dp = new int[str.length()];

        for( int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            String compareStr = st.nextToken();
            int score = Integer.parseInt(st.nextToken());
            map.put(compareStr, score);
        }

        //System.out.println(bfs());
        System.out.println(dfs(0));

    }
}


/*
private static int bfs() {
        PriorityQueue<int[]> q = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        q.add(new int[]{1, 0}); //index, value
        int[] dp = new int[str.length() + 1];


        while(!q.isEmpty()) {
            int[] node = q.poll();
            int index = node[0];
            int value = node[1];

            if(index >= str.length()) break;
            for (String key : map.keySet()) {
                int score = map.get(key);
                int size = key.length() - 1;
                if(str.startsWith(key, index) && index - size >= 0) {
                    dp[index] = Math.max(dp[index - size] + score, dp[index]);
                    q.add(new int[]{index + size, value + score});
                }
            }
            q.add(new int[]{index + 1, value + 1});
            dp[index] = Math.max(dp[index], dp[index - 1] + 1);
        }
        return dp[str.length()];
    }
 */