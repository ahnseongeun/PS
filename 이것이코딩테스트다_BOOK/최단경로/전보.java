package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
3 2 1
1 2 4
1 3 2
 */
public class 전보 {
    private static int distance[];

    private static void display(int graph[][]){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< graph.length;i++){
            for(int j=1;j< graph.length;j++){
                sb.append(graph[i][j]+" ");
            }
            sb.append("\n");
        }
        sb.append("distance: ");
        for(int i=1;i< distance.length;i++){
            sb.append(distance[i]+" ");
        }
        sb.append("\n");
        System.out.println(sb);
    }

    private static void result(int[][] graph) {
        int count=0;
        int max=0;
        for(int i=1;i<graph.length;i++){
            for(int j=1;j< graph.length;j++){
                if(graph[i][j]==0||graph[i][j]==1000000000)
                    continue;
                count++;
            }
        }

        for(int i=1;i<distance.length;i++){
            max=Math.max(max,distance[i]);
        }
        System.out.println("count: "+count +"\n"+"distance: "+max);
    }

    private static void dijkstra(int[][] graph, int startNode) {
        // 거리, 노드 번호
        int size= graph.length;
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        pq.add(new int[]{0,startNode}); //거리,노드 번호
        while(!pq.isEmpty()){
            startNode=pq.poll()[1];
            for(int i=1;i<size;i++){
                if(graph[startNode][i]==0||startNode==i)
                    continue;
                if(distance[i]>distance[startNode]+graph[startNode][i]){
                    distance[i]=distance[startNode]+graph[startNode][i];
                    pq.add(new int[]{distance[i],i});
                }
            }
        }
        display(graph);
        result(graph);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        distance = new int[n+1];
        int graph[][]=new int[n+1][n+1];
        Arrays.fill(distance,1000000000);
        distance[c]=0;
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i],1000000000);
            graph[i][i]=0;
        }

        for(int i=1;i<=m;i++){
            st= new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[start][target]=value;
        }

        dijkstra(graph,c);

    }
}
