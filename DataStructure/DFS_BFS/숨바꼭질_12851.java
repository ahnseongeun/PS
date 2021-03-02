package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0일때 처리하는 것이 관건
 */
public class 숨바꼭질_12851 {

    private static int k;
    private static boolean visited[];

    private static void bfs(int n) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n,0});
        visited[n] = true;
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            int position = tmp[0];
            int count = tmp[1];
            if(position == k) {
                System.out.println(count);
                break;
            }

            if(position + 1 <= 200000 && !visited[position + 1]) {
                visited[position + 1] = true;
                q.add(new int[]{position + 1, count + 1});
            }

            if(position - 1 >= 0 && !visited[position - 1]) {
                visited[position - 1] = true;
                q.add(new int[]{position - 1, count + 1});
            }

            //일단 올리고 내려오는 것도 생각
            if(position * 2 <= 200000 && !visited[position * 2]) {
                visited[position * 2] = true;
                q.add(new int[]{position * 2, count + 1});
            }

        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[200001];
        bfs(n);

    }
}
