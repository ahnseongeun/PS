package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
3
3
5 5 4
3 9 1
3 2 7
5
3 7 2 0 1
2 8 0 9 1
1 2 1 8 1
9 8 9 2 0
3 6 5 1 5
7
9 0 5 1 1 5 3
4 1 2 1 6 5 3
0 7 6 1 6 8 5
1 1 7 8 3 2 3
9 4 0 7 6 4 1
5 8 3 2 4 8 3
7 4 8 4 8 3 4
 */

/**
 * 2차원 배열 distance를 이용해서 최소 값이 될 때 마다 갱신해주는 것이 포인트이다.
 * 최소 값이 될 때 마다 갱신해주기 때문에 방문 배열이 필요없다.
 * 우선 순위 큐를 이용해서 가장 작은 값을 먼저 이용해서 효율적으로 탐색이 가능하다.
 */
public class 화성탐사 {
    static int direction_x[]={0,0,-1,1}; //상하좌우
    static int direction_y[]={-1,1,0,0};
    static int distance[][];
    private static void display(int[][] graph){
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< graph.length;i++){
            for(int j=1;j< graph.length;j++){
                sb.append(distance[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void dijkstra(int[][] graph) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return 0;
            }
        });
        int x=1;
        int y=1;
        int next_x=0;
        int next_y=0;
        int next_value=graph[x][y];
        int size=graph.length;
        pq.add(new int[]{graph[x][y],x,y});
        distance[x][y]=next_value;
        while(!pq.isEmpty()){
            int temp[]=pq.poll();
            for(int i=0;i<4;i++){
                next_x=temp[1]+direction_x[i];
                next_y=temp[2]+direction_y[i];
                if(next_x<1||next_y<1||next_x>size-1||next_y>size-1)
                    continue;
                next_value=temp[0]+graph[next_x][next_y];
                if(distance[next_x][next_y]>next_value){
                    distance[next_x][next_y]=next_value;
                    pq.add(new int[]{next_value,next_x,next_y});
                }
            }
            //display(graph);
        }
        System.out.println(distance[size-1][size-1]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        for(int k=0;k<n;k++){
            int m=Integer.parseInt(input.readLine());
            int graph[][]=new int[m+1][m+1];
            distance=new int[m+1][m+1];
            for(int i=0;i<=m;i++)
                Arrays.fill(distance[i],1000000000);
            StringTokenizer st;
            for(int i=1;i<=m;i++){
                st=new StringTokenizer(input.readLine());
                for(int j=1;j<=m;j++){
                    graph[i][j]=Integer.parseInt(st.nextToken());
                }
            }
            dijkstra(graph);
        }
    }
}