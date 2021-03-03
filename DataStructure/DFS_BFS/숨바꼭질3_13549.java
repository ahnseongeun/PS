package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 우선순위 큐를 써서 * 2 인 값을 먼저 처리하도록 하면 될 것같다.
 */
public class 숨바꼭질3_13549 {

    private static int k;
    private static int visited[];
    private static void dfs(int n) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        pq.add(new int[]{n,0});
        visited[n] = 0;
        int result = 100000;
        while(!pq.isEmpty()){
            int[] tmp = pq.poll();

            int position = tmp[0];
            int level = tmp[1];

            if(position == k){
                result = level;
                break;
            }

            if(position + 1 <= 100000 && visited[position + 1] >= level){
                visited[position + 1] = level;
                pq.add(new int[]{position + 1, level + 1});
            }

            if(position - 1 >= 0 && visited[position - 1] >= level){
                visited[position - 1] = level;
                pq.add(new int[]{position - 1, level + 1});
            }

            if(position != 0 && position <= 50000 && visited[position * 2] >= level){
                visited[position * 2] = level;
                pq.add(new int[]{position * 2, level});
            }
        }
        System.out.println(result);

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited,100000);
        k = Integer.parseInt(st.nextToken());
        dfs(n);
    }
}
