package DataStructure.tree;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
5
1 3 2 -1
2 4 4 -1
3 1 2 4 3 -1
4 2 4 3 3 5 6 -1
5 4 6 -1
 */

/**
 * 트리에서 가장 긴 지름을 구하는 것
 * 가장 긴 지름은 어떻게 구하면 될까?
 * 1. 어떤 노드에서 DFS를 통해서 가장 긴 노드의 Index를 구한다.
 * 2. 구한 노드에서 가장 노드와의 거리를 구하면 그것이 트리의 지름이다.
 * -> 모든 노드에서 DFS를 진행하는 방식은 N^2의 방식이지만
 * -> 1번과 2번으로 나눠서 진행한다면 2N 즉, 선형으로 정답을 구할 수 있다.
 */
public class 트리의지름_1167 {

    static ArrayList<int[]>[] list;
    static boolean[] visited;
    static int maxWeight = -1;
    static int maxIndex = -1;

    /*
        가장 길게 DFS하기
     */
    static void getLongDistanceInTree(int index, int weight) {

        if(weight > maxWeight) {
            maxWeight = weight;
            maxIndex = index;
        }
        visited[index] = true;

        for(int[] node : list[index]) {
            int next = node[0];
            int distance = node[1];
            if(visited[next]) continue;
            visited[next] = true;
            getLongDistanceInTree(next, weight + distance);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        list = new ArrayList[100001];
        for(int i = 0; i < list.length; i++) list[i] = new ArrayList<>();
        int n = Integer.parseInt(input.readLine());
        visited = new boolean[n + 1];
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new int[]{target, weight});
            //트리에 삽입
            while(true) {
                target = Integer.parseInt(st.nextToken());
                if(target == -1) break;
                weight = Integer.parseInt(st.nextToken());
                list[start].add(new int[]{target, weight});
            }
        }
        getLongDistanceInTree(1, 0);
        maxWeight = -1;
        Arrays.fill(visited, false);
        getLongDistanceInTree(maxIndex, 0);
        System.out.println(maxWeight);
    }
}
