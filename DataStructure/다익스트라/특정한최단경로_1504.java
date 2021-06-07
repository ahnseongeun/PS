package DataStructure.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 다익스트라인데 특정 경로를 지나면서 최단 경로를 만족하는 거리 구하기
 * 양방향
 *
 */
/*
4 5
1 2 3
3 4 1
1 3 5
2 4 5
1 4 4
2 3
 */
public class 특정한최단경로_1504 {

    private static ArrayList<ArrayList<int[]>> paths;
    private static int[] distance;

    private static int dijkstra(int start, int target) {

        Arrays.fill(distance, 200000001);
        distance[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));
        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){

            int[] node = pq.poll();
            int index = node[0];

            for(int[] path : paths.get(index)){

                if(distance[path[0]] > distance[index] + path[1]){
                    distance[path[0]] = distance[index] + path[1];
                    pq.add(new int[]{path[0],distance[path[0]]});
                }

            }
        }

        return distance[target];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        paths = new ArrayList<>();
        distance = new int[n + 1];

        //paths 초기화
        for(int i = 0; i <= n; i++)
            paths.add(new ArrayList<int[]>());

        //paths weight 저장
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            paths.get(start).add(new int[]{end, weight});
            paths.get(end).add(new int[]{start, weight});
        }


        st = new StringTokenizer(input.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());
        int a = dijkstra(1, target1);
        int b = dijkstra(target1, target2);
        int c = dijkstra(target2, n);
        int result = a + b + c;
        a = dijkstra(1, target2);
        b = dijkstra(target2, target1);
        c = dijkstra(target1, n);
        result = Math.min(result, (a + b + c));
        System.out.println(result > 200000000 ? -1 : result);
    }
}
