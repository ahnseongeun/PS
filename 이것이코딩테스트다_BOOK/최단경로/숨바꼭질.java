package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
/*
6 7
3 6
4 3
3 2
1 3
1 2
2 4
5 2
 */
public class 숨바꼭질 {
    static int distance[];
    private static void display() {
        StringBuilder sb=new StringBuilder();
        int idx=1;
        int count=0;
        for(int i=1;i<distance.length;i++){
            if(distance[i]>distance[idx]) {
                idx = i;
                count=0;
            }
            count++;
            sb.append(distance[i]+" ");
        }
        sb.append("\n"+idx+" "+distance[idx]+" "+count);
        System.out.println(sb);

    }

    private static void dijkstra(int[][] graph) {

        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int size=graph.length;
        pq.add(new int[]{0,1});//value,start
        while(!pq.isEmpty()){
            int temp[]=pq.poll();
            int startNode=temp[1];
            for(int i=1;i<size;i++){
                if(i==startNode||graph[startNode][i]==0)
                    continue;
                if(distance[i]>distance[startNode]+graph[startNode][i]){
                    distance[i]=distance[startNode]+graph[startNode][i];
                    pq.add(new int[]{distance[i],i});
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
        int graph[][]=new int[n+1][n+1];
        distance=new int[n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(distance,100000000);
            distance[1]=0;
        }
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int target=Integer.parseInt(st.nextToken());
            graph[start][target]=1;
            graph[target][start]=1;
        }
        dijkstra(graph);
    }
}
