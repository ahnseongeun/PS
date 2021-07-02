package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 다시_숨바꼭질_1697 {

    private static int bfs(int start, int target) {

        Queue<int[]> q = new LinkedList<>();
        boolean check[] = new boolean[200001];
        q.add(new int[]{start, 0});
        while(!q.isEmpty()){
            int[] location = q.poll();
            int idx = location[0];
            int cnt = location[1];
            if(check[idx]) continue;
            check[idx] = true;
            if(idx == target) return cnt;
            if(idx < 100001) q.add(new int[]{idx * 2, cnt + 1});
            if(idx < 100001) q.add(new int[]{idx + 1, cnt + 1});
            if( idx > 0) q.add(new int[]{idx - 1, cnt + 1});
        }
        return 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int result = bfs(start,target);
        System.out.println(result);
    }
}
