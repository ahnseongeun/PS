package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.InputStreamReader;
import java.util.*;

/*
첫째 줄에 공간의 크기 N(2 ≤ N ≤ 20)이 주어진다.

둘째 줄부터 N개의 줄에 공간의 상태가 주어진다.
공간의 상태는 0, 1, 2, 3, 4, 5, 6, 9로 이루어져 있고, 아래와 같은 의미를 가진다.

N*N 크기

물고기 M 마리

아기 상어 1마리 , 처음 크기가 2, 1초에 상하좌우,
자신의 크기보다 큰 물고기가 있는 칸을 지날 수 없다.
작은 물고기 먹기 가능 , 같으면 안됨
물고기가 한마리 남았다면 그 물고기를 먹으러간다.
1마리 보다 많다면, 거리가 가장 가까운 물고기를 먹으러 간다.
거리가 가까운 물고기가 많다면, 가장 위에 있는 물고기, 여러마리라면,
그 중 가장 왼쪽에 있는 물고기

물고기를 먹으면 그 칸은 빈 칸, 자신의 크기와 같은 수의 물고기를 먹을
때 마다 크기가 1증가한다.
총 몇초

한칸에는 물고기 최대 1마리


0: 빈 칸
1, 2, 3, 4, 5, 6: 칸에 있는 물고기의 크기
9: 아기 상어의 위치
아기 상어는 공간에 한 마리 있다.
3
0 0 1
0 0 0
0 9 0
 */
/*
물고기 M, 한칸에 물고기 최대 1마리
아기 상어의 크기는 2
자신의 크기보다 큰 물고기가 있는 칸은 지나갈 수 없다.
아기 상어는 자신의 크기보다 작은 물고기만 먹을 수 있다.
- 하지만 크기가 같다면 통과는 가능하다.
- 자신의 크기만큼 물고기를 먹으면 크기가 증가한다.
- 물고기가 한마리면 그 물고기를 먹으러 간다.
- 거리가 같다면 가장 위에 있는 물고기, 가장 왼쪽에 있는 물고기 순이다.
 */
public class 아기상어_16236 {

    private static int map[][];
    private static int dx[] = {-1, 0, 1, 0}; //좌,상,우,하
    private static int dy[] = {0, -1, 0, 1}; //좌,상,우,하
    private static int n;
    private static int shark_size = 2;
    private static int count = 0;
    private static boolean visited[][];
    private static int targetY = 0,targetX = 0;
    private static ArrayList<int[]> fish;

    private static int bfs(int start_y, int start_x, int target_y, int target_x) {

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start_y,start_x,0});
        int result = 0;
        while(!q.isEmpty()){
            int[] location = q.poll();
            int y = location[0];
            int x = location[1];
            int level = location[2];

            for(int i = 0 ; i < 4; i++){
                int next_y = y + dy[i];
                int next_x = x + dx[i];
                if(next_y < 0 || next_x < 0 || next_y >= n || next_x >= n || visited[next_y][next_x])
                    continue;
                if(map[next_y][next_x] > shark_size)
                    continue;
                if(next_x == target_x && next_y == target_y){
                    count++;
                    map[next_y][next_x] = 0;
                    if(count == shark_size) {
                        shark_size++;
                        count = 0;
                    }
                    result = level + 1;
                    q.clear();
                    break;
                }
                visited[next_y][next_x] = true;
                q.add(new int[]{next_y, next_x , level + 1});
            }
        }
        return result;
    }

    private static boolean check(int start_y, int start_x) {

        int minD = 10000000;
        int minX = 10000000;
        int minY = 10000000;
        if(fish.isEmpty())
            return false;

        int idx = -1;;
        for(int i = 0; i < fish.size(); i++){
            int fish_y = fish.get(i)[0];
            int fish_x = fish.get(i)[1];
            int distance = Math.abs(start_x - fish_x) + Math.abs(start_y - fish_y);
            //System.out.println(start_y + " " + start_x + " " + fish_y + " " + fish_x + " "+ shark_size);
            if(shark_size > map[fish_y][fish_x]) {
                if (minD > distance) {
                    minD = distance;
                    minY = fish_y;
                    minX = fish_x;
                    idx = i;
                }else if( minD == distance){
                    if(minY > fish_y){
                        minY = fish_y;
                        minX = fish_x;
                        idx = i;
                    }else if(minY == fish_y){
                        if(minX > fish_x){
                            minX = fish_x;
                            idx = i;
                        }
                    }
                }
            }
        }
        if(idx > -1) {
            targetY = minY;
            targetX = minX;
            fish.remove(idx);
            return true;
        }
        return false;
    }

    private static int search(int start_y, int start_x) {
        int result = 0;
        int target_x = -1;
        int target_y = -1;
        while(true) {
            //배열 초기화
            for (int j = 0; j < n; j++)
                Arrays.fill(visited[j], false);

            //먹거리가 없으면 break;
            if(check(start_y,start_x)){
                target_y = targetY;
                target_x = targetX;
            }else{
                break;
            }

            //최단거리 탐색
            result += bfs(start_y, start_x, target_y, target_x);
            //System.out.println(target_y + " " + target_x +" " +result);
            //display();
            start_x = target_x;
            start_y = target_y;
        }

        return result;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        map = new int[n][n];
        visited = new boolean[n][n];
        fish = new ArrayList<>();
        int start_x = 0;//아기상어 초반 위치
        int start_y = 0;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    map[i][j] = 0;
                    start_y = i;
                    start_x = j;
                }
                if(map[i][j] >= 1 && map[i][j] <= 6)
                    fish.add(new int[]{i,j});
            }
        }
        System.out.println(search(start_y,start_x));
    }

    private static void display() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
