package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 1. 층마다 자르면 몇개나오는지 저장하기
 * 2. 가장 최소가 되면서 해당 개수 구하기
 */
/*
6 7
1
5
3
3
5
1
 */
public class 개똥벌레_3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int[] bottom = new int[h + 1];
        int[] top = new int[h + 1];
        int[] result = new int[h + 1];

        //bottom과 top 높이마다 해당층의 개수 구하기
        for(int i = 0; i < n; i++) {
            int num = Integer.parseInt(input.readLine());
            if(i % 2 == 0) {
                bottom[num]++;
                continue;
            }
            top[num]++;
        }

        //누적합 구하기
        for(int i = 1; i <= h; i++) {
            top[i] += top[i - 1];
            bottom[i] += bottom[i - 1];
        }
        for(int i = 0; i < top.length; i++) sb.append(top[i]).append(" ");
        System.out.println(sb);

        //가장 적을 때와 count 구하기
        for(int i = 1; i <= n; i++) {
            //result[i] =
        }


    }
}
