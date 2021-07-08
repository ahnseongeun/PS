package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
7
5 0
1 1 1
3 1 2
6 1 1
1 2 2 4
8 2 2 4
4 3 3 5 6
 */

/**
 * 왜 Math.max로 최대 시간을 구해야하는지 궁금했다.
 * 모든 작업이 완료되는 것이므로 모든 선행 조건을 만족하는 것 모든 노드를 다돌았다는 전제이므로 최장 거리르 구하는 것.
 */
public class 작업_2056 {

    private static int topologySort(int n, int[] times, int[] indegree, ArrayList<ArrayList<Integer>> jobs) {

        int[] result = new int[n + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i < indegree.length; i++){
            if(indegree[i] == 0){
                result[i] = times[i];
                q.add(i);
            }
        }

        while(!q.isEmpty()) {
            int start = q.poll();

            for(int end : jobs.get(start)) {
                indegree[end]--;
                if(result[end] < result[start] + times[end]) result[end] = result[start] + times[end];
                if(indegree[end] == 0) q.add(end);
            }
        }

        int max = 0;
        for( int i = 1; i < result.length; i++) max = Math.max(max,result[i]);
        return max;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        ArrayList<ArrayList<Integer>> jobs = new ArrayList<>();
        int[] times = new int[n + 1];
        int[] indegree = new int[n + 1];
        for( int i = 0; i <= n; i++) jobs.add(new ArrayList<>());

        for( int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            times[i] = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            for( int j = 0; j < m; j++) {
                int preJob = Integer.parseInt(st.nextToken());
                indegree[i]++;
                jobs.get(preJob).add(i);
            }
        }

        System.out.println(topologySort(n,times,indegree,jobs));

    }
}
