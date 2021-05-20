package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
8 8
........
........
...x.xx.
...xxx..
..xxx...
..x.xxx.
..x...x.
.xxx..x.
5
6 6 4 3 1
 */
//(r - 3 + 1)
public class 미네랄2_18500 {

    private static char map[][];
    private static int arr[];
    private static int visited[][];// 1,바닥 클러스터 2 공중 클러스터
    private static int r,c,n;
    private static int dx[] = {0, 1, 0, -1}; //상우하좌
    private static int dy[] = {-1, 0, 1, 0};
    private static StringBuilder sb = new StringBuilder();

    //막대기를 던져서 있으면 제거
    private static void getMineralShape(int floor, int direction) {

        if(direction == 0){
            for(int i = 1; i <= c; i++){
                if(map[floor][i] == 'x'){
                    map[floor][i] = '.';
                    break;
                }
            }
        }else{
            for(int i = c; i >= 1; i--){
                if(map[floor][i] == 'x'){
                    map[floor][i] = '.';
                    break;
                }
            }
        }
        //BFS로 바닥에 있는 x를 이용해서 공중에 떠있는 클러스터를 찾는다.
        getCluster();
        //바닥부터 점검해서 가장 가까운 클러스터 찾아서 제거
        down();
    }

    private static void getCluster() {

        for(int i = 0; i <= r; i++)
            Arrays.fill(visited[i],0);

        //바닥에 붙은 x를 큐에 넣는다.
        Queue<int[]> q = new LinkedList<>();
        for(int i = 1; i <= c; i++)
            if(map[r][i] == 'x') {
                visited[r][i] = 1;
                q.add(new int[]{r,i});
            }

        //바닥에 있는 미네랄을 기준으로 공중을 제외한 클러스터는 1로 표시
        while(!q.isEmpty()){
            int[] location = q.poll();
            for(int i = 0; i < 4; i++){
                int next_y = location[0] + dy[i];
                int next_x = location[1] + dx[i];
                if(next_x < 1 || next_y < 1 || next_y > r || next_x > c)
                    continue;
                if(visited[next_y][next_x] == 1 || map[next_y][next_x] == '.')
                    continue;
                visited[next_y][next_x] = 1;
                q.add(new int[]{next_y,next_x});
            }
        }
        
        //클러스터 표시
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                if(map[i][j] == 'x' && visited[i][j] == 0)
                    visited[i][j] = 2;
            }
        }
    }

    private static void down() {

        //바닥에 닿아 있지 않다면 클러스터 중에 최소값을 구하기
        int min = 1000;
        for(int i = 1; i <= c; i++){
            int index = r;
            boolean flag = false;
            for(int j = r; j >= 1; j--){
                if(visited[j][i] == 2) {
                    index = j;
                    flag = true;
                    break;
                }
            }
            if(flag) {
                int value = 0;
                for (int j = index; j <= r; j++) {
                    if (visited[j][i] == 1)
                        break;
                    value++;
                }

                min = Math.min(min, value - 1);
            }
        }

        //내리기
        for(int i = r; i >= 1; i--){
            for(int j = 1; j <= c; j++){
                if(visited[i][j] != 2)
                    continue;
                map[i + min][j] = 'x';
                map[i][j] = '.';
            }
        }
    }

    private static void display() {
        for(int i = 1; i <= r; i++){
            for(int j = 1; j <= c; j++){
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r + 1][c + 1];
        visited = new int[r + 1][c + 1];

        //초기 map 초기화
        for(int i = 1; i <= r; i++){
            String str = input.readLine();
            for(int j = 1; j <= c; j++){
                map[i][j] = str.charAt(j - 1);
            }
        }

        n = Integer.parseInt(input.readLine());
        st = new StringTokenizer(input.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        //좌우 번갈아서 한번씩 던지기
        int direction = 0;
        for(int i = 0; i < n; i++){
            getMineralShape((r - arr[i] + 1),direction % 2 == 1 ? 1 : 0);
            direction++;
        }
        display();

    }
}
