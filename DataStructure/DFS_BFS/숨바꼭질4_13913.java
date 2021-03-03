package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 숨바꼭질4_13913 {

    private static int k;
    private static int visited[];
    //private static int path[];

    private static void bfs(int n) throws IOException {

        StringBuilder sb = new StringBuilder();
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{n, 0});
        visited[n] = n;

        while (!q.isEmpty()) {
            int tmp[] = q.poll();
            int position = tmp[0];
            int level = tmp[1];

            if (k == position) {
                System.out.println(level);
                sb.insert(0, position + " ");
                while (position != n) {
                    sb.insert(0, visited[position] + " ");
                    position = visited[position];
                    System.out.println(sb);
                    break;
                }

                // x + 1
                if (position < 100000 && visited[position + 1] == -1) {
                    visited[position + 1] = position;
                    q.add(new int[]{position + 1, level + 1});
                }

                // x - 1
                if (position > 0 && visited[position - 1] == -1) {
                    visited[position - 1] = position;
                    q.add(new int[]{position - 1, level + 1});
                }

                // x * 2
                if (position <= 50000 && visited[position * 2] == -1) {
                    visited[position * 2] = position;
                    q.add(new int[]{position * 2, level + 1});
                }

            }
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        Arrays.fill(visited,-1);
        k = Integer.parseInt(st.nextToken());
        bfs(n);
    }
}
