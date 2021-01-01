package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


/**
 * 개선된 다익스트라는 거리가 최소가 되어서 변경될때만 Q에 삽입하기 때문에
 * 방문배열에 필요없다. 이미 한번 방문되었으면 다시 돌아가지 않는다.
 * 시간복잡도는 O(ElogV)이다.
 */
public class 개선된다익스트라 {
    static int distance[];

    private static void display() {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<distance.length;i++)
            sb.append(distance[i]+" ");
        System.out.println(sb);
    }

    private static void dijkstra(int startNode, int[][] graph) {
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
            for(int i=1;i<graph.length;i++){
                if(i==startNode||graph[startNode][i]==0)
                    continue;
                if(distance[i]>distance[startNode]+graph[startNode][i]) {
                    distance[i] = distance[startNode] + graph[startNode][i];
                    pq.add(new int[]{distance[i], i});
                }
            }
        }
        display();
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

        for(int i=0;i<m;i++){
            st=new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int target=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            graph[start][target]=value;
        }
        
        dijkstra(startNode,graph);

    }
}
