package DataStructure.다익스트라;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
(1≤V≤20,000, 1≤E≤300,000)
O(ElogV)
 */
public class 최단경로_1753 {

    private static ArrayList<ArrayList<int[]>> paths;
    private static int[] distance;
    private static boolean[] visited;

    private static void dijkstra(int start_num) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>(){
            //첫번째가 노드번호, 두번째가 거리
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[]{start_num,0});

        while(!pq.isEmpty()){
            int[] node = pq.poll();
            int index = node[0]; //index는 시작
            List<int[]> list = paths.get(index);

            visited[index] = true;

            for(int[] info : list){

                //자기 자신이거나 거리가 0이면 , info는 목적지
                if(info[0] == index)
                    continue;

                //조건을 만족하면 삽입
                if(distance[index] + info[1] < distance[info[0]]){
                    distance[info[0]] = distance[index] + info[1];
                    pq.add(new int[]{info[0],distance[info[0]]});
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < distance.length; i++)
            if(!visited[i]){
                sb.append("INF").append("\n");
            }else{
                sb.append(distance[i]).append("\n");
            }

        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start_num = Integer.parseInt(input.readLine());

        paths = new ArrayList<>();
        distance = new int[n + 1];
        visited = new boolean[n + 1];
        Arrays.fill(distance,2000000000);
        distance[start_num] = 0;
        for(int i = 0; i <= n; i++) paths.add(new ArrayList<>());


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            paths.get(start).add(new int[]{end,weight});

            //시간초과
//            boolean flag = false;
//            for(int j = 0; j < paths.get(start).size(); j++) {
//                int[] tmp = paths.get(start).get(j);
//
//                if(tmp[0] == end) {
//                    flag = true;
//                    if (tmp[1] > weight) {
//                        paths.get(start).set(j,new int[]{end, weight});
//                        break;
//                    }
//                }
//            }
//            if(!flag)
//                paths.get(start).add(new int[]{end,weight});

        }

        dijkstra(start_num);
    }
}
