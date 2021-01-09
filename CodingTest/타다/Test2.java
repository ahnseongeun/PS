package CodingTest.타다;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test2 {
    static int distance[];
    static int total[];

    private static void display() {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i<distance.length;i++)
            sb.append(distance[i]+" ");
        System.out.println(sb);
    }

    private static void dijkstra(int startNode, int[][][] graph,int totalBound) {
        //거리, 노드
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }
                return o1[0]-o2[0];
            }
        });
        pq.add(new int[]{0,0,startNode}); //거리와 스타트 노드
        while(!pq.isEmpty()){
            int temp[]=pq.poll(); //temp[0]의 거리는 우선순위 큐를 만들때만 사용된다.
            startNode=temp[2];
            for(int i=1;i<graph.length;i++){
                if(i==startNode||graph[startNode][i][0]==0)
                    continue;
                //System.out.println("startnode"+startNode+" "+"i: "+i);
                if(distance[i]>distance[startNode]+graph[startNode][i][0]) {
                    //System.out.println(total[startNode]+graph[startNode][i][1]);
                    if(total[startNode]+graph[startNode][i][1]>totalBound)
                        continue;
                    total[i]=total[startNode]+graph[startNode][i][1];
                    distance[i] = distance[startNode] + graph[startNode][i][0];
                    pq.add(new int[]{distance[i], total[i],i});
                }
            }
        }
        //display();
    }
    public int solution2(int n,int m, int[][] paths){
        int size= paths.length;
        int graph[][][]=new int[n+1][n+1][2];
        distance=new int[n+1];
        total=new int[n+1];
        Arrays.fill(distance,10000000);
        distance[1]=0;
        for(int i=0;i<size;i++){
            int start=paths[i][0];
            int target=paths[i][1];
            int time=paths[i][2];
            int value=paths[i][3];
            graph[start][target][0]=time;
            graph[start][target][1]=value;
        }

        dijkstra(1,graph,m);
        int result=0;
        if(distance[n]==10000000)
            result=-1;
        else
            result=distance[n];
        System.out.println(result);
        return result;
    }
}
