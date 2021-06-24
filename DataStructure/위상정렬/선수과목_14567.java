package DataStructure.위상정렬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 선수과목_14567 {

    private static void topologySort(int n, int[] indegree, boolean[][] map) {

        Queue<int[]> q = new LinkedList<>();
        int[] result = new int[n + 1];
        //indegree가 0인 것을 넣는다.
        for(int i = 1; i <= n; i++) {
            if(indegree[i] == 0) {
                q.add(new int[]{i,1});
            }
        }

        while(!q.isEmpty()){
            int[] subject = q.poll();
            int idx = subject[0];
            int semester = subject[1];

            for(int i = 1; i <= n; i++){
                if(map[idx][i]) {
                    indegree[i]--;
                    if(indegree[i] == 0){
                        result[i] = semester + 1;
                        q.add(new int[]{i,semester + 1});
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= n; i++) sb.append(result[i]+ " ");
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] indegree = new int[n + 1];
        boolean[][] map = new boolean[n + 1][n + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            map[start][end] = true;
            indegree[end]++;
        }
        topologySort(n,indegree,map);
    }
}
