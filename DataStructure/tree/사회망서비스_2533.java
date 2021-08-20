package DataStructure.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
8
1 2
1 3
1 4
2 5
2 6
4 7
4 8
 */
/**
 * 내 인생 첫 트리 DP 문제이다.
 * 트리라는 조건을 이용해서 DFS를 이용해서 탐색을 진행하고 리프 노드에 도달 후 다시 돌아오는 과정에서
 * DP에 최솟값들이 될 수 있는 값들을 저장하면서 풀 수 있는 문제이다.
 * 모든 노드는 연결되어 있다. -> 어디서 시작을 해도 상관이 없다.
 */
public class 사회망서비스_2533 {

    static int[][] dp;
    static boolean[] visited;
    static ArrayList<Integer>[] tree;
    static void dfs(int index) {

        visited[index] = true;
        dp[index][0] = 0; // 얼리가 아니라면
        dp[index][1] = 1; // 얼리라면 1

        for(int next_index : tree[index] ) {
            if(visited[next_index]) continue;
            //다음 노드로 dfs
            dfs(next_index);
            //얼리가 아닐경우 주변 노드는 모두 얼리여야 한다.
            dp[index][0] += dp[next_index][1];
            // 현재 노드가 얼리라면, 주변은 얼리 또는 얼리가 아니다.
            dp[index][1] += Math.min(dp[next_index][0], dp[next_index][1]);

        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];
        tree = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 1; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            tree[start].add(end);
            tree[end].add(start);
        }

        dfs(1);
        System.out.println(Math.min(dp[1][0],dp[1][1]));
    }
}
