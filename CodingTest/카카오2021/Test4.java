package CodingTest.카카오2021;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test4 {

    static int distance[];
    static int[][] graph;
    static int[][] reverse_graph;
    static int state = 0; // 0이면 graph, 1이면 reverse_graph

    private static void setGraph(int[][] roads){
        for(int i = 0; i < roads.length; i++){
            graph[roads[i][0]][roads[i][1]] = roads[i][2];
            reverse_graph[roads[i][1]][roads[i][0]] = roads[i][2];
        }
    }
    private static int solution(int n, int start, int end, int[][] roads, int[] traps) {
        graph = new int[n + 1][n + 1];
        reverse_graph = new int[n + 1][n + 1];
        setGraph(roads);
        distance=new int[n+1];
        Arrays.fill(distance,10000000);
        distance[start]=0;
        return dijkstra(start,traps,end);
    }


    private static int dijkstra(int startNode, int[] trap, int end) {
        //거리, 노드
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        pq.add(new int[]{0,startNode});
        while(!pq.isEmpty()){
            int temp[]=pq.poll(); //temp[0]의 거리는 우선순위 큐를 만들때만 사용된다.
            startNode=temp[1];
            boolean flag = false;
            if(startNode == end)
                flag = true;
            for(int i = 0; i < trap.length; i++) {
                if(trap[i] == startNode)
                    state = state == 1 ? 0 : 1;
            }
            if(state == 0) {
                for (int i = 1; i < graph.length; i++) {
                    if (i == startNode || graph[startNode][i] == 0)
                        continue;
                    if (distance[i] > distance[startNode] + graph[startNode][i]) {
                        distance[i] = distance[startNode] + graph[startNode][i];
                        pq.add(new int[]{distance[i], i});
                        flag = true;
                    }
                }
                if(!flag){
                    for (int i = 1; i < graph.length; i++) {
                        if(graph[startNode][i] != 0) {
                            distance[i] = distance[startNode] + graph[startNode][i];
                            pq.add(new int[]{distance[i], i});
                        }
                    }
                }

            }else{
                for (int i = 1; i < reverse_graph.length; i++) {
                    if (i == startNode || reverse_graph[startNode][i] == 0)
                        continue;
                    if (distance[i] > distance[startNode] + reverse_graph[startNode][i]) {
                        distance[i] = distance[startNode] + reverse_graph[startNode][i];
                        pq.add(new int[]{distance[i], i});
                        flag = true;
                    }
                }
                if(!flag){
                    for (int i = 1; i < graph.length; i++) {
                        if(graph[startNode][i] != 0) {
                            distance[i] = distance[startNode] + graph[startNode][i];
                            pq.add(new int[]{distance[i], i});
                        }
                    }
                }
            }
        }
        display();
        return distance[end];
    }


    public static void main(String[] args) throws Exception{
//        int n = 4;
//        int start = 1;
//        int end = 4;
//        int[][] roads = {{1, 2, 1}, {3, 2, 1}, {2, 4, 1}};
//        int[] trap = {2, 3};
        int n = 3;
        int start = 1;
        int end = 3;
        int[][] roads = {{1, 2, 2}, {3, 2, 3}};
        int[] trap = {2};
        System.out.println(solution(n,start,end,roads,trap));

    }
    private static void display() {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<distance.length;i++)
            sb.append(distance[i]+" ");
        System.out.println(sb);
    }

}
