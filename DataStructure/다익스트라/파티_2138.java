package DataStructure.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
4 8 2
1 2 4
1 3 2
1 4 7
2 1 1
2 3 5
3 1 2
3 4 4
4 2 3
 */
public class 파티_2138 {

    private static int city[][];
    private static int distance[][];
    private static boolean visited[];

    private static void dijkstra(int start) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> o1[1] - o2[1]));

        pq.add(new int[]{start, 0});

        while(!pq.isEmpty()){

            int[] node = pq.poll();
            int index = node[0];

            for(int i = 1; i < distance.length; i++){

                if(city[index][i] == 0)
                    continue;

                if(distance[start][i] > distance[start][index] + city[index][i]){
                    distance[start][i] = distance[start][index] + city[index][i];

                    pq.add(new int[]{i,distance[start][i]});

                }
            }
        }
    }

    private static int getMax(int x) {

        int result = -1;
        for(int i = 1; i < distance.length; i++){
            if(distance[i][x] == 0 || distance[x][i] == 0)
                continue;
            result = Math.max(result, distance[i][x] + distance[x][i]);
        }
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        city = new int[n + 1][n + 1];
        distance = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            city[start][end] = weight;
        }


        for(int i = 1; i <= n; i++){
            Arrays.fill(distance[i], 2000000000);
            Arrays.fill(visited, false);
            distance[i][i] = 0;
            dijkstra(i);

        }
        System.out.println(getMax(x));

    }
}

/*
StringBuilder sb = new StringBuilder();
                    for(int k = 1; k < distance.length; k++){
                        for(int j = 1; j < distance.length; j++){
                            sb.append(distance[k][j] + " ");
                        }
                        sb.append("\n");
                    }
                    System.out.println(sb);
 */
