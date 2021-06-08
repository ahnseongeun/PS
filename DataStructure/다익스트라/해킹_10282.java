package DataStructure.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
2
3 2 2
2 1 5
3 2 5
3 3 1
2 1 2
3 1 8
3 2 4
 */

/**
 * BFS에서 최대한 깊게 진행하려는 문제에서 다익스트라를 사용한다??
 */
public class 해킹_10282 {

    private static StringBuilder sb = new StringBuilder();
    private static ArrayList<ArrayList<int[]>> paths;
    private static int distance[];


    private static void hacking(int n, int start) {

        distance = new int[n + 1];
        Arrays.fill(distance, 1000000001);
        distance[start] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);

        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int index = node[0];

            for(int[] path : paths.get(index)){

                if(distance[path[0]] > distance[index] + path[1]){
                    distance[path[0]] = distance[index] + path[1];
                    pq.add(new int[]{path[0], distance[path[0]]});
                }
            }
        }

        int max = -1;
        int count = 0;
        for(int i = 1; i < distance.length; i++){
            if(distance[i] != 1000000001){
                count++;
                max = Math.max(max, distance[i]);
            }
        }
        sb.append(count).append(" ").append(max).append("\n");
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(input.readLine());

        for(int i = 0; i < k; i++){
            paths = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(input.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int start_node = Integer.parseInt(st.nextToken());

            for(int j = 0; j <= n; j++) paths.add(new ArrayList<>());

            for(int j = 0; j < m; j++){
                st = new StringTokenizer(input.readLine());
                int end = Integer.parseInt(st.nextToken());
                int start = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                paths.get(start).add(new int[]{end, weight});
            }

            hacking(n, start_node);
        }
        System.out.println(sb);
    }
}
