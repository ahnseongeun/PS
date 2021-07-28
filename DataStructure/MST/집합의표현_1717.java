package DataStructure.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
7 8
0 1 3
1 1 7
0 7 6
1 7 1
0 3 7
0 4 2
0 1 1
1 1 1
 */
public class 집합의표현_1717 {

    private static int[] parent;

    private static int find(int index) {
        if(index == parent[index]) return index;
        return parent[index] = find(parent[index]);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        //부모초기화
        for(int i = 1; i <= n; i++) parent[i] = i;

        //간선 초기화
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int command = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            // union
            if( command == 0) {
                union(start, end);
            }
            // 둘이 같은 집합인지 check
            else {
                int startRootIdx = find(start);
                int endRootIdx = find(end);
                if( startRootIdx == endRootIdx) {
                    sb.append("YES");
                } else {
                    sb.append("NO");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);

    }

    private static void union(int start, int end) {
        int startRootIdx = find(start);
        int endRootIdx = find(end);
        if( startRootIdx < endRootIdx) parent[endRootIdx] = startRootIdx;
        else parent[startRootIdx] = endRootIdx;
    }
}
