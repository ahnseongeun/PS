package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
5 4
3 1
3 2
4 3
5 3
 */
public class 효율적인해킹_1325 {
    private static ArrayList<Integer>[] list;
    private static int[] result;

    private static void dfs(int idx, boolean[] visited) {

        visited[idx] = true;
        for( int index : list[idx]) {
            if(visited[index]) continue;
            result[index]++;
            dfs(index,visited);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++) list[i] = new ArrayList<>();

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list[start].add(end);
        }
        result = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            dfs(i, visited);
        }
        int max = 0;
        for(int i = 1; i <= n; i++){
            max = Math.max(result[i],max);
        }
        for(int i = 1; i <= n; i++){
            if(result[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
