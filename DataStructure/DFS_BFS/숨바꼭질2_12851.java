package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질2_12851 {

    private static int k;
    private static int visited[];

    private static void bfs(int n) {
        StringBuilder sb = new StringBuilder();

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n,0});
        int count = 0;
        int result = 0;
        visited[n] = 0;

        while(!q.isEmpty()){
            int tmp[] = q.poll();
            int position = tmp[0];
            int level = tmp[1];

            if(position == k){
                count++;
                result = level;
            }

            if(position + 1 <= 200000 && visited[position + 1] >= level ){
                visited[position + 1] = level;
                q.add(new int[]{position + 1,level + 1});
            }

            if(position - 1 >= 0 && visited[position - 1] >= level ){
                visited[position - 1] = level;
                q.add(new int[]{position - 1,level + 1});
            }

            if(position * 2 <= 200000 && visited[position * 2] >= level ){
                visited[position * 2] = level;
                q.add(new int[]{position * 2,level + 1});
            }

        }
        System.out.println(result);
        System.out.println(count);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new int[200001];
        Arrays.fill(visited,100000);
        bfs(n);
    }
}
