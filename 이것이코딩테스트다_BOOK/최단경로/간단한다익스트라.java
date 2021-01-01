package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
6 11
1
1 2 2
1 3 5
1 4 1
2 3 3
2 4 2
3 2 3
3 6 5
4 3 3
4 5 1
5 3 1
5 6 2
 */
/**
 * 시작 노드가 주어졌을 때 목표 노드까지 최단거리가 얼마나 걸리는 구하는 문제
 * startNode가 1이 아닐경우는 어떻게 처리할까?
 * 최단 거리로 다음 노드를 탐색하는 방법으로 문제를 해결할수 있다.
 */
public class 간단한다익스트라 {
    static boolean visited[];
    static int distance[];

    private static void display() {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<distance.length;i++)
            sb.append(distance[i]+" ");
        System.out.println(sb);
    }
    private static int searchMin(){
        int min=10000000;
        int idx=1;
        for(int i=1;i<distance.length;i++){
            if(visited[i])
                continue;
            if(min>distance[i]){
                min=distance[i];
                idx=i;
            }
        }
        return idx;
    }

    private static void dijkstra(int startNode, int[][] graph) {
        //O(V^2)의 시간 복잡도를 가진다.
        for(int i=1;i< graph.length;i++){
            for(int j=1;j<graph.length;j++){
                if(j==startNode||graph[startNode][j]==0)
                    continue;
                distance[j]=Math.min(distance[j],graph[startNode][j]+distance[startNode]);
            }
            visited[startNode]=true;
            startNode=searchMin();
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int startNode=Integer.parseInt(input.readLine());
        int graph[][]=new int[n+1][n+1];
        distance=new int[n+1];
        Arrays.fill(distance,10000000);
        distance[startNode]=0;
        visited=new boolean[n+1];

        for(int i=1;i<=m;i++){
            st=new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int target=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            graph[start][target]=value;
        }
        dijkstra(startNode,graph);
        display();
    }
}
