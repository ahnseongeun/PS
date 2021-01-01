package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
TestCase1
5 7
1 2
1 3
1 4
2 4
3 4
3 5
4 5
4 5

TestCase2
4 2
1 3
2 4
3 4
 */

/**
 * start, target, mid 순서로 진행하자.
 *
 */
public class 미래도시 {

    private static void display(int[][] graph) {
        StringBuilder sb=new StringBuilder();
        for(int i=1;i< graph.length;i++){
            for(int j=1;j< graph.length;j++){
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
                for(int target=1;target<size;target++){
                    graph[start][target]=Math.min(graph[start][target],graph[start][mid]+graph[mid][target]);
                }
            }
        }
        display(graph);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=new StringTokenizer(input.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());
        int graph[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i],1000000000);
            graph[i][i]=0;
        }

        for(int i=1;i<=m;i++){
            st=new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int target=Integer.parseInt(st.nextToken());
            graph[start][target]=1;
            graph[target][start]=1;
        }

        // 1 -> k -> x
        st=new StringTokenizer(input.readLine());
        int x=Integer.parseInt(st.nextToken());
        int k=Integer.parseInt(st.nextToken());

        floyd(graph);
        int result=(graph[1][k]+graph[k][x]);
        System.out.println("result: "+ (result>=1000000000?-1:result));
    }
}
