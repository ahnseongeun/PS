package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
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
public class 최소비용구하기_1916 {

    public static int city[][];
    public static int distance[];

    private static int dijkstra(int start, int end){

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){

            @Override
            public int compare(int v1[], int v2[]){
                return v1[1] - v2[1];
            }
        });

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){

            int[] node = pq.poll();
            start = node[0];

            for(int i = 1; i < city.length; i++){

                if(i == start || city[start][i] == 0)
                    continue;

                if(distance[i] > distance[start] + city[start][i]){
                    distance[i] = distance[start] + city[start][i];
                    pq.add(new int[]{i,distance[i]});
                }
            }
        }

        return distance[end];
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(input.readLine());
        int m = Integer.parseInt(input.readLine());
        city = new int[n + 1][n + 1];
        distance = new int[n + 1];
        Arrays.fill(distance, 2000000000);

        for(int i = 0; i < m ; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            city[start][end] = Math.min(city[start][end],weight);
        }

        StringTokenizer st = new StringTokenizer(input.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        distance[start] = 0;

        System.out.println(dijkstra(start,end));

    }
}
