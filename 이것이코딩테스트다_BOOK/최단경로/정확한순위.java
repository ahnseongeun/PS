package 이것이코딩테스트다_BOOK.최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
6 6
1 5
3 4
4 2
4 6
5 2
5 4
 */

/**
 * graph와 floyd 탐색을 할 때는 단방향이지만
 * 양방향 중 하나라도 비교할수 있으면 되기 때문에 결과값을 출력할때는 양방향이다.
 */
public class 정확한순위 {
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
        int n= Integer.parseInt(st.nextToken());
        int m= Integer.parseInt(st.nextToken());
        int graph[][]=new int[n+1][n+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(graph[i],1000000000);
            graph[i][i]=0;
        }
        for(int i=1;i<=m;i++){
            st=new StringTokenizer(input.readLine());
            int start=Integer.parseInt(st.nextToken());
            int target=Integer.parseInt(st.nextToken());
            graph[start][target]=1; //방향은 단방향이지만
            //graph[target][start]=1;
        }
        floyd(graph);
        int result=0;
        for(int i=1;i<=n;i++){
            int count=0;
            for(int j=1;j<=n;j++){
                if(graph[i][j]!=1000000000||graph[j][i]!=1000000000) //검사는 양방향
                    count++;
            }
            if(count==n) {
                System.out.println(i);
                result += 1;
            }
        }
        System.out.println(result);
    }
}
