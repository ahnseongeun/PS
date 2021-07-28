package DataStructure.삼성SDS알고리즘;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
3 4
1 2 4
1 3 3
2 3 -1
3 1 -2
 */

/**
 * 밸만포드의 특징 중 하나는 음수의 최대 값은 V * E * -Cost
 * 1. 음수 순환이 존재하면 -1 출력
 *
 */
public class 타임머신_11657 {

    private static int n;
    private static int m;
    private static ArrayList<int[]>[] list;
    private static final Long INF = 10000000000L;

    private static boolean bellmanford(long[] dist) {

        dist[1] = 0;
        for(int i = 1; i <= n; i++) { //노드의 개수
            for(int j = 1; j <= n; j++) { //간선의 개수
                for(int k = 0; k < list[j].size(); k++) {
                    int[] edge = list[j].get(k);
                    int end = edge[0];
                    int weight = edge[1];

                    if (dist[j] == INF) continue;

                    if (dist[end] > dist[j] + weight) {
                        dist[end] = dist[j] + weight;
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++) {
            for(int j = 0; j < list[i].size(); j++) {
                int[] edge = list[i].get(j);

                int start = i;
                int end = edge[0];
                int weight = edge[1];

                if(dist[start] == INF) continue;
                if( dist[end] > dist[start] + weight) {
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n + 1];
        long[] dist = new long[n + 1];
        Arrays.fill(dist, INF);
        //list 초기화
        for(int i = 0; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        //간선 초기화
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new int[]{end, weight});
        }

        if(bellmanford(dist)) {
            //음수 싸이클이 있다면 -1
            System.out.println(-1);
        } else {
            //음수 싸이클이 없다면 dist를 탐색하면선 갈수 없는 곳은 -1 갈수 있다면 weight 출력
            StringBuilder sb = new StringBuilder();
            for(int i = 2; i <= n; i++) {
                if(dist[i] == INF)
                    sb.append(-1).append("\n");
                else
                    sb.append(dist[i]).append("\n");
            }
            System.out.println(sb);
        }

    }
}
