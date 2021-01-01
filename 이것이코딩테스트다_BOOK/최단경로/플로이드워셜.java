package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
4
7
1 2 4
1 4 6
2 1 3
2 3 7
3 1 5
3 4 4
4 3 2
 */

/**
 * 2차원 배열을 이용해서 모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구해야 하는 경우
 * 사용할 수 있는 알고리즘
 * 시간복잡도는 O(N^3)
 */
public class 플로이드워셜 {
    private static void display(int graph[][]){
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
        int n=Integer.parseInt(input.readLine());
        int graph[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i],1000000000);
            graph[i][i]=0;
        }
        //display(graph);
        StringTokenizer st;
        int m=Integer.parseInt(input.readLine());
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int target=Integer.parseInt(st.nextToken());
            int value=Integer.parseInt(st.nextToken());
            graph[start][target]=value;
        }
        floyd(graph);
    }
}
