package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
2 10
3 5 5
5 2 2
 */

/**
 * 1. 신호등 좌표 받아오기
 * 2. 현재 시간 % (빨간 + 초록)
 * 3. 초록이면 다시 좌표 받아오기, 빨간이면 빨간 - 남은 시간 + 좌표 받아오기
 */
public class 도로와신호등_2980 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        ArrayList<int[]> location = new ArrayList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            location.add(new int[]{idx, red, green});
        }

        int start = 0;
        int time = 0;
        while(!location.isEmpty()) {

            int[] temp = location.remove(0);

            int light_location = temp[0];
            int red = temp[1];
            int green = temp[2];

            time += (light_location - start);
            int state = time % (red + green);
            /**
             * **기준을 빨간불일때 얼마나 기다려야 하는가를 정하는 것이다.**
             *
             * 나는 왜 red >= state && state > 0이렇게 접근 했는데
             * 정답은 왜 red >= state일때 만 일까
             * state = 0 이라는 것은 red - 0 으로 5초 즉 5초를 기다려야한다.
             * state = red 라면 red - red로 0초를 기다려야 한다.
             *
             */
            if (red >= state)
                time += red - state;
            start = light_location;
        }
        //마지막 남은 거리만큼 시간을 더해준다.
        System.out.println(time + l - start);
    }
}
