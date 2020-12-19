package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2606_바이러스 {
    static boolean visited[];
    static int count=0;
    private static void virusSearch(int[][] virus, int idx) {
        visited[idx]=true; //BFS처럼 옆으로 값을 구해야 할때는 visited를 for문 위로 빼야한다.
        for(int i=1;i<virus.length;i++){
            if(virus[idx][i]==0||visited[i])
                continue;
            count++;
            virusSearch(virus,i);
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        int arraySize=Integer.parseInt(input.readLine());
        int edgeSize=Integer.parseInt(input.readLine());
        int virus[][]=new int[arraySize+1][arraySize+1];
        visited=new boolean[arraySize+1];
        visited[1]=true;
        StringTokenizer st;

        for(int i=1;i<=edgeSize;i++){
            st=new StringTokenizer(input.readLine());
            int start= Integer.parseInt(st.nextToken());
            int target= Integer.parseInt(st.nextToken());
            virus[start][target]=1;
            virus[target][start]=1;
        }
        virusSearch(virus,1);
        System.out.println(count);

    }
}
