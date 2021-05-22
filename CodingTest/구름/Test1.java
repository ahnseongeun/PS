package CodingTest.구름;

import java.io.*;
import java.util.*;

/**
 n명, i번째 참가자가 먹을 수 있는 음식의 최대 ai
 */
/*
4 3
8 6 7 1
 */
public class Test1 {

    private static int arr[];
    private static StringBuilder sb;

    private static void execute_foodFight(int k){
        int idx = k - 1;
        int cnt = arr.length;
        while(cnt != 0){
            arr[idx]--;
            if(arr[idx] == 0) {
                cnt--;
                sb.append(idx + 1).append(" ");
            }
            idx = (idx + 1) % arr.length;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[n];
        sb = new StringBuilder();
        st = new StringTokenizer(input.readLine());

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        execute_foodFight(k);
        System.out.println(sb);
    }
}