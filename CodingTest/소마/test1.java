package CodingTest.소마;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * h g f w r
 * 4
 * g w
 * h g
 * h f
 * g r
 */

/**
 * arr[i][i]를 처음에 0이라고 가정 - 연계
 * 2번째 변수에 한번이라도 나오면 1로 변환
 * 0인수만 시작점 표시시  */
public class test1 {

    private static int n;
    private static boolean visited[][];
    private static int arr[][];
    private static int path[];
    private static HashMap<Integer,Character> map1;
    private static StringBuilder sb = new StringBuilder();

    private static void bfs(int index) {

        Queue<Integer> q = new LinkedList<>();
        q.add(index);
        while(!q.isEmpty()) {
            int start = q.poll();
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (start == i || arr[start][i] == 0) {
                    cnt++;
                    continue;
                }
                q.add(i);
                path[i] = start;
            }

            if(cnt == n){
                sb.append(map1.get(start)).append(" ");
                while(index != start){
                    sb.append(map1.get(path[start])).append(" ");
                    start = path[start];
                }
                System.out.println(sb.reverse().deleteCharAt(0));
                sb = new StringBuilder();
            }
        }

    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = st.countTokens();

        HashMap<Character,Integer> map = new HashMap<>();
        map1 = new HashMap<>();
        for(int i = 0; i < n; i++) {
            char ch = st.nextToken().charAt(0);
            map.put(ch, i);
            map1.put(i,ch);
        }

        arr = new int[n][n];
        path = new int[n];
        LinkedList<Integer> startList = new LinkedList<>();

        int m = Integer.parseInt(input.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(input.readLine());
            int start = map.get(st.nextToken().charAt(0));
            int end = map.get(st.nextToken().charAt(0));
            arr[start][end] = 1;
            arr[end][end] = 1;
        }

        for(int i = 0; i < n; i++)
            if(arr[i][i] == 0)
                startList.add(i);

        for(int number : startList) {
            bfs(number);
        }

    }
}
