package DataStructure.MST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
4
5
4
4
3
0 2 2 2
2 0 3 3
2 3 0 4
2 3 4 0
 */

/**
 * 자기 자신을 포함 해야 될 때는 가상의 노드를 만들어서 진행한다.
 */
public class 물대기_1368 {

    private static int find(int node, int[] parent) {
        if(node == parent[node]) return node;
        return find(parent[node], parent);
    }

    private static void union(int startIdx, int endIdx, int[] parent) {

        int startRootIdx = find(startIdx, parent);
        int endRootIdx = find(endIdx, parent);
        if(startRootIdx < endRootIdx) parent[endRootIdx] = startRootIdx;
        else parent[startRootIdx] = endRootIdx;
    }

    private static int getMinWater(int n, int[] weights, int[][] map) {

        int result = 0;

        /**
         * 유니온 파인드 순서
         * 1. pq에 가중치 혹은 거리 순으로 정렬한다.
         * 2. parent 배열 초기화
         * 3. start와 end 노드의 find를 구한다.
         * 4. 둘이 같다면 부모가 같기 때문에 continue
         * 5. 둘이 같지않다면 같은 부모를 가지도록 union 진행.
         */

        int[] parent = new int[n + 1];
        for(int i = 0; i <=n; i++) parent[i] = i;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);

        for(int i = 0; i <= n; i++) {
            for( int j = 0; j <= n; j++) {
                if(i == j) continue;
                if(i != 0 && j != 0) {
                    pq.add(new int[]{i, j, map[i][j]});
                    continue;
                }
                pq.add(new int[]{0, j, weights[j]});
            }
        }


        int cnt = 0;

        while(!pq.isEmpty()) {
            int[] node = pq.poll();
            int start = node[0];
            int end = node[1];
            int value = node[2];
            int startRootIdx = find(start, parent);
            int endRootIdx = find(end, parent);

            if( startRootIdx == endRootIdx) continue;
            union(startRootIdx, endRootIdx, parent);
            result += value;
            cnt++;
            if(cnt == n) break;

        }


        return result;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] weights = new int[n + 1];
        for( int i = 1; i <= n; i++) {
            int w = Integer.parseInt(input.readLine());
            weights[i] = w;
        }
        int[][] map = new int[n + 1][n + 1];
        for( int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for( int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(getMinWater(n,weights,map));

    }
}
