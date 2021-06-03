package DataStructure.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
첫째 줄에 도시의 개수 N, 도로의 개수 M, 거리 정보 K, 출발 도시의 번호 X
4 4 2 1
1 2
1 3
2 3
2 4
 */

/**
 * 첫번째 풀이 메모리 초과
 * -> city의 수가 300,000이여서 최대 90000000000의 노드 발생
 * 그럼 어떻게 메모리를 줄이지??
 * O(ElogV)로 풀어야하는데...
 * LinkedList를 이용해서 동적으로 생성하기
 */
public class 특정거리의도시찾기_18352 {

    private static ArrayList<ArrayList<Integer>> city;
    private static int distance[];

    private static void dijkstra(int start, int target) {

        //노드번호, 거리 순
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        pq.add(new int[]{start,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int node_number = node[0];
            ArrayList<Integer> list = city.get(node_number);
            for(int i : list){
                //자기 자신이거나 갈수없다면 continue;
                if(i == node_number || node[1] > target)
                    continue;
                //현재 거리보다 더 작다면 최신화 하기
                if(distance[node_number] + 1 < distance[i]){
                    distance[i] = distance[node_number] + 1;
                    pq.add(new int[]{i, distance[i]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < distance.length; i++)
            if(distance[i] == target) sb.append(i).append("\n");
        System.out.println(sb.toString().length() == 0 ? -1 : sb.toString());

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        //n은 도시의 개수, m은 도로의 개수, k는 거리정보, x는 출발 도시의 번호
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        city = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i <= n; i++)
            city.add(new ArrayList<>());
        distance = new int[n + 1];

        Arrays.fill(distance,100000000);
        distance[start] = 0;

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            city.get(s).add(d);
        }

        dijkstra(start,target);
    }
}
