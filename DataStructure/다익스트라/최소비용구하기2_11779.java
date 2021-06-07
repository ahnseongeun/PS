package DataStructure.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/*
5
8
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
1 5
 */

public class 최소비용구하기2_11779 {

    private static ArrayList<ArrayList<int[]>> cities;
    private static int[] distance; //최단 거리
    private static int path[]; //경로

    private static int dijkstra(int start, int end) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2) -> o1[1] - o2[1]);
        pq.add(new int[]{start, 0});
        Arrays.fill(distance,1000000001);
        distance[start] = 0;

        while(!pq.isEmpty()){
            int[] city = pq.poll();
            int index = city[0];

            for(int[] node : cities.get(index)){

                if(distance[node[0]] > distance[index] + node[1]){
                    distance[node[0]] = distance[index] + node[1];
                    pq.add(new int[]{node[0], distance[node[0]]});
                    path[node[0]] = index;
                }

            }

        }

        return distance[end];
    }

    private static int getCount(int end) {
        int index = end;
        int count = 0;
        while(index != 0) {
            index = path[index];
            count++;
        }
        return count;
    }

    private static String backtracking(int end) {

        StringBuilder sb = new StringBuilder();

        int index = end;
        sb.append(end);
        while(true){
            index = path[index];
            if(index == 0) break;
            sb.insert(0, index + " ");
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        cities = new ArrayList<>();
        distance = new int[n + 1];
        path = new int[n + 1];

        //ArrayList 초기화
        for(int i = 0; i <= n; i++) cities.add(new ArrayList<int[]>());

        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            cities.get(start).add(new int[]{end,weight});
        }

        StringTokenizer st = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        sb.append(dijkstra(start,end)).append("\n");
        sb.append(getCount(end)).append("\n");
        sb.append(backtracking(end));
        System.out.println(sb);
    }
}
