package DataStructure.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
3 3
1 2 1
2 3 2
1 3 3
 */
public class 최소스패닝트리_1197 {

    private static int find(int index, int[] parent) {
        if(index == parent[index]) return index;
        return parent[index] = find(parent[index],parent);
    }

    private static void union(int start, int end, int[] parent) {
        int startRoot = find(start,parent);
        int endRoot = find(end,parent);
        if(startRoot < endRoot) parent[endRoot] = startRoot;
        else parent[startRoot] = endRoot;
    }

    private static void display(int[] parent) {
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < parent.length; i++) sb.append(parent[i]).append(" ");
        System.out.println(sb);
    }


    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            pq.add(new int[]{start, end, distance});
        }

        //초기화
        int[] parent = new int[n + 1];
        for(int i = 1; i <= n; i++) parent[i] = i;

        int distance = 0;
        int cnt = 0;
        while(!pq.isEmpty()) {
            int[] node = pq.poll();

            int start = find(node[0],parent);
            int end = find(node[1],parent);
            if(start == end) continue;
            union(start, end, parent);
            distance += node[2];
            cnt++;
            if(cnt == n - 1) break;
        }

        System.out.println(distance);
    }

}
