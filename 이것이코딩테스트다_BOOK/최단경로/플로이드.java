package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
5
14
1 2 2
1 3 3
1 4 1
1 5 10
2 4 2
3 4 1
3 5 1
4 5 3
3 5 10
3 1 8
1 4 2
5 1 7
3 4 2
5 2 4
 */
public class 플로이드 {
    private static void display(int[][] graph) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< graph.length;i++){
            for(int j=1;j< graph.length;j++){
                if(graph[i][j]==1000000000)
                    graph[i][j]=0;
                sb.append(graph[i][j]+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void floyd(int[][] graph) {
        int size= graph.length;
        for(int mid=1;mid<size;mid++){
            for(int start=1;start<size;start++){
                if(mid==start)
                    continue;
                for(int target=1;target<size;target++){
                    if(mid==target||start==target)
                        continue;
                    graph[start][target]=Math.min(graph[start][target],graph[start][mid]+graph[mid][target]);
                }
            }
        }
        display(graph);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int n=Integer.parseInt(input.readLine());
        int m=Integer.parseInt(input.readLine());
        int graph[][]=new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            Arrays.fill(graph[i],1000000000);
            graph[i][i]=0;
        }

        for(int i=1;i<=m;i++){
            StringTokenizer st=new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int target=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            graph[start][target]=Math.min(graph[start][target],value);
        }

        floyd(graph);
    }
}
