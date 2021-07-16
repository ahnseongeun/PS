package CodingTest.scpc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
2
5
1 1 3 3 3
10
8 10 5 4 2 5 1 3 1 9
 */

/**
 * 유니온 파인드에서 결과를 비교 할 때는 항상 parent[i]가 아닌 find(parent[i])로 루트 값을 비교하자.
 */
public class Test1 {

    private static int find(int start, int[] parent) {
        if(start == parent[start]) return start;
        parent[start] = find(parent[start], parent);
        return parent[start];
    }

    private static void union(int startRootIdx, int endRootIdx, int[] parent) {
        int startIdx = find(startRootIdx, parent);
        int endIdx = find(endRootIdx, parent);
        parent[endIdx] = startIdx;
    }

    private static int unionFind(int number, int[] arr) {

        int result = 0;

        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i <= number; i++)
            if(arr[i] + i <= number)
                q.add(new int[]{i, arr[i] + i});

        int[] parent = new int[1000000];
        for(int i = 1; i <= number; i++) {
            parent[i] = i;
        }

        while(!q.isEmpty()) {
            int[] node = q.poll();
            int start = node[0];
            int end = node[1];
            int startRootIdx = find(start, parent);
            int endRootIdx = find(end, parent);

            if(startRootIdx == endRootIdx) continue;
            union(startRootIdx, endRootIdx, parent);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= number; i++) sb.append(find(i,parent)).append(" ");
        System.out.println(sb);
        Set<Integer> set = new HashSet<>();
        for(int i = 1; i <= number; i++) if(set.add(find(i,parent))) result++;
        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());
        for(int i = 0; i < n; i++) {
            int number = Integer.parseInt(input.readLine());
            StringTokenizer st = new StringTokenizer(input.readLine());
            int[] arr = new int[number + 1];
            for(int j = 1; j <= number; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            sb.append("Case #").append(i + 1).append(" ").append("\n").append(unionFind(number, arr)).append("\n");
        }
        System.out.println(sb);
    }
}
