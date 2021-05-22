package DataStructure.DFS_BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 처음 생각 할때 공간복잡도를 500 ^ 3으로 생각했다. 하지만 최대 500 + 500 + 500 -> 1500까지 가능해서
 * 제대로 생각하면 1500 ^ 3이다. 하지만 당연히 공간복잡도 초과이고 더 좋은 방법은
 * a + b + c의 합이 일정하는 것이다. 그래서 visited[a][b] = c 이렇게 공간 복잡도를 줄일 수 있다.
 *
 */
/*
//이문제의 핵심은 합이 일정하다 -> 그래서 500 ^ 3이 아니라 최대 값인 1500의 배열에 값을 넣어서 표시한다.
10 15 35
그 다음, 돌의 개수가 작은 쪽을 X, 큰 쪽을 Y라고 정한다.
그 다음, X에 있는 돌의 개수를 X+X개로, Y에 있는 돌의 개수를 Y-X개로 만든다.
 */
public class 돌그룹_12866 {

    private static int check[][];

    private static int checkEqual(int[] data) {

        int a = data[0]; int b = data[1]; int c = data[2];
        Queue<int[]> q = new LinkedList<>();
        check[a][b] = c - b - a ;
        q.add(new int[]{a,b,c});

        while(!q.isEmpty()){

            int[] rock = q.poll();
            Arrays.sort(rock);
            int a_weight = rock[0];
            int b_weight = rock[1];
            int c_weight = rock[2];

            if(a_weight == b_weight && b_weight == c_weight)
                return 1;

            if(a_weight < b_weight){
                if(check[2 * a_weight][b_weight - a_weight] == c_weight)
                    continue;

                check[2 * a_weight][b_weight - a_weight] = c_weight;
                q.add(new int[]{2 * a_weight,b_weight - a_weight,c_weight});
            }

            if(a_weight < c_weight){
                if(check[2 * a_weight][c_weight - a_weight] == b_weight)
                    continue;

                check[2 * a_weight][c_weight - a_weight] = b_weight;
                q.add(new int[]{2 * a_weight,c_weight - a_weight,b_weight});
            }

            if(b_weight < c_weight){
                if(check[2 * b_weight][c_weight - b_weight] == a_weight)
                    continue;

                check[2 * b_weight][c_weight - b_weight] = a_weight;
                q.add(new int[]{2 * b_weight,c_weight - b_weight,a_weight});
            }
        }

        return 0;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int data[] = new int[3];
        data[0] = Integer.parseInt(st.nextToken());
        data[1] = Integer.parseInt(st.nextToken());
        data[2] = Integer.parseInt(st.nextToken());
        Arrays.sort(data);
        check = new int[1501][1501];

        System.out.println(checkEqual(data));
    }
}
