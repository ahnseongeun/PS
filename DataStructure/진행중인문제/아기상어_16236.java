package DataStructure.진행중인문제;

import java.io.BufferedReader;
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

/**
 * 1. 물고기의 위치를 저장한다.
 * 2. 물고기의 위치를 점검해서 조건에 맞는 위치를 찾는다.
 * 3. 현재 상어의 위치에서 물고기의 위치까지 최단 거리를 찾는다.
 * 4. 상어의 위치를 초기화 하고 1번 반복
 */
public class 아기상어_16236 {

    private static int n;
    private static int start_x;
    private static int start_y;
    private static int weight;
    private static int map[][];
    private static int dx[] = {0, -1 , 1, 0}; //상, 좌, 우 , 하
    private static int dy[] = {-1, 0, 0, 1};
    private static ArrayList<int[]> fish_location;

    private static int calDisTance(int x, int y, int target_x, int target_y) {

        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[n][n];
        q.add(new int[]{y,x,0});
        while(!q.isEmpty()){
            int[] temp = q.poll();
            x = temp[0];
            y = temp[1];
            int level = temp[2];
            if(x == target_x && y == target_y){
                result = level;
                break;
            }

            for(int i = 0; i < 4; i++){
                int next_x = x + dx[i];
                int next_y = y + dy[i];

                if(next_x < 0 || next_y < 0 || next_x >= n || next_y >= n )
                    continue;

                if(map[next_y][next_x] > weight && !visited[next_y][next_x])
                    continue;

                visited[next_y][next_x] = true;
                q.add(new int[]{next_y, next_x, level + 1});
            }
            System.out.println(q.size());
        }
        return result;
    }

    private static int searchFish(int x, int y) {

        //조건(위치, 크기)를 만족하는 물고기의 위치 찾기
        /**
         * 조건 1. 거리가 제일 가까운 것
         * 조건 2. 거리가 가까운 것 중에서 제일 위, 위도 같으면 제일 좌인 것
         */
        int min = 1000000;
        int pre_x = 10000;
        int pre_y = 10000;
        for(int[] location : fish_location){
            int fish_y = location[0];
            int fish_x = location[1];
            int distance = calDisTance(x,y,fish_x,fish_y);
            if(min > distance){
                min = distance;
                pre_x = fish_x;
                pre_y = fish_y;
            //거리가 제일 가깝다면 제일 위에 있는 좌표
            }else if(min == distance){

                if(fish_y == pre_y){
                    pre_x = fish_x;
                }else{
                    pre_y = fish_y;
                }
            }
        }
        remove_location(pre_y,pre_x);

        return min;
    }

    private static int calTime() {

        int time = 0;

        //물고기가 없는 경우
        while(!fish_location.isEmpty()){
            display();
            //물고기가 한마리만 남았을 경우
            if(fish_location.size() == 1) {
                //무게 비교 후에 갈 수 있다면 거리만큼 시간 늘리기
                for(int i = 0; i < n; i++){
                    for(int j = 0; j < n; j++){
                        if(map[i][j] > 0 && map[i][j] < 9) {
                            time += calDisTance(start_x, start_y, j, i);
                            remove_location(j, i);
                            return time;
                        }
                    }
                }
            }
            //조건(위치, 크기)을 만족하는 물고기의 위치 찾기
            time += searchFish(start_x,start_y); //가야할 물고기 위치 좌표 반환 하기
        }

        return time;
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
        System.out.println(fish_location.size());
    }

    private static void remove_location(int next_y, int next_x) {
        int result = 0;
        int idx = 0;
        for(int[] location: fish_location){
            if(location[0] == next_y && location[1] == next_x) {
                result = idx;
                break;
            }
            idx++;
        }
        fish_location.remove(result);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(input.readLine());
        map = new int[n][n];
        fish_location = new ArrayList<>();
        weight = 2;

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                //물고기의 좌표와 크기
                if(map[i][j] > 0 && map[i][j] < 9)
                    fish_location.add(new int[]{i,j});

                //아기 상어 초기 위치
                if(map[i][j] == 9){
                    start_x = j;
                    start_y = i;
                    map[i][j] = 0;
                }
            }
        }

        System.out.println(calTime());
    }
}
