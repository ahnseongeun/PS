package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
4 40
6
3 4 20
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20
 */

/**
 * 최대한 많은 마을을 거쳐가면서 상자를 내려야 한다.
 * 1. 2차원에 배열에 보내야 하는 박스 저장
 * 2.
 */
public class 택배_8980 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());

        int box[] = new int[n + 1];
        int capacity = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(input.readLine());
        ArrayList<int[]> list = new ArrayList<>();

        for(int i = 0; i < m ; i++){
            st = new StringTokenizer(input.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list.add(new int[]{start, end, weight});
        }

        //받는 마을 순으로 오름 차순 정리, 보내는 마을 순으로 오름 차순 정리
        list.sort((o1, o2) -> {
            if (o1[1] - o2[1] == 0) {
                return o1[0] - o2[0];
            } else {
                return o1[1] - o2[1];
            }
        });

        for(int i = 0; i < list.size(); i++){
            int[] send = list.get(i);
            int start = send[0];
            int end = send[0];
            int weight = send[0];

            //받는 마을에서 최대 용량 보다 작다면 계속 채우기

        }
    }
}









