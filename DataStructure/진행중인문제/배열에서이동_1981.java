package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
5
1 1 3 6 8
1 2 2 5 5
4 4 0 3 3
8 0 2 3 4
4 3 0 2 1

2
1 2
3 4
 */

/**
 * 완전 탐색을 할 경우 시간복잡도는?
 * 탐색의 마지막 인덱스는 배열의 (최대값 - 최소값)
 *
 * https://gre-eny.tistory.com/304
 * https://hsdevelopment.tistory.com/549
 */
public class 배열에서이동_1981 {

    static int[][] arr;
    static boolean[][] visited;
    static int[] dx = {0, 1, 0, -1}; //상, 우, 하, 좌
    static int[] dy = {-1, 0, 1, 0}; //상, 우, 하, 좌
    static int n;
    static Set<Integer> set = new HashSet<>();
    static ArrayList<Integer> list = new ArrayList<>();

    static boolean bfs(int minValue, int maxValue) {

        if (arr[0][0] < minValue || arr[0][0] > maxValue) {
            return false;
        }

        visited = new boolean[n][n];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0}); // y, x, max 값, max - min의 최소값
        visited[0][0] = true;

        while(!q.isEmpty()) {

            int[] node = q.poll();
            int y = node[0];
            int x = node[1];

            if (y == n - 1 && x == n - 1) {
                return true;
            }
            for (int i = 0; i < 4; i++) {
                int next_y = y + dy[i];
                int next_x = x + dx[i];
                if (next_y < 0 || next_x < 0 || next_y >= n || next_x >= n || visited[next_y][next_x]) continue;
                if (arr[next_y][next_x] < minValue || arr[next_y][next_x] > maxValue) continue;
                visited[next_y][next_x] = true;
                q.add(new int[]{next_y, next_x});
            }
        }

        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        arr = new int[n][n];

        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                set.add(arr[i][j]);
            }
        }


        list.addAll(set);
        Collections.sort(list);

        //중복없이 오름차순 정렬

        int idx1 = 0;
        int idx2 = 0;
        int end = list.size();
        int result = 201;
        //투포인터를 통해서 모든 MAX - MIN 값이 가능한 수들 중에서 최솟값을 찾는다.
        while(idx1 < end && idx2 < end) {

            int minValue = list.get(idx1);
            int maxValue = list.get(idx2);

            //(MAX - MIN)이 가능한 배열의 원소라는 말은 해당 원소가 MAX보다 크고 MIN보다 작다는 말이다.
            boolean check = bfs(minValue, maxValue);

            //check = true라면 끝까지 도달 했다는 것
            if(check) {
                result = Math.min(result, maxValue - minValue);

                //도달 가능하면 idx1++을 통해서 MIN값을 증가시켜서 (MAX - MIN)값을 감소시킨다.
                idx1++;
            } else {
                idx2++;
            }
        }
        System.out.println(result);

    }
}
