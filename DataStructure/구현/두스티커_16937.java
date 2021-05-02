package DataStructure.구현;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 먼저 시간 복잡도를 계산해보면
 * N개의 스티커중 2개를 선택하는 경우의 수는 NC2이고
 * 회전이 가능하기 때문에 가로 가로, 가로 세로, 세로 가로, 세로 세로 4가지
 * 붙히는 방법에는 세로를 연속해서 붙히기, 가로를 연속해서 붙히기 2가지
 * 즉, N^2 * 4 * 2 이다.
 * 그럼 어떤 식으로 탐색을 해야할까?
 * 세로 세로로 붙힐 경우 h1 + h2 < h, w1과 w2중 최댓값
 * 가로 가로로 붙힐 경우 w1 + w2 < w, h1과 h2중 최댓값
 */
/*
10 9
4
2 3
1 1
5 10
9 11
 */
public class 두스티커_16937 {

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(input.readLine());
        int[][] location = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            location[i][0] = Integer.parseInt(st.nextToken());
            location[i][1] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        int sum = w * h;
        for(int i = 0; i < n; i++){
            for(int k1 = 0; k1 < 2; k1++) {
                int x1 = location[i][k1 == 0 ? 0 : 1];
                int y1 = location[i][k1 == 0 ? 1 : 0];
                for (int j = i + 1; j < n; j++) {
                    for(int k2 = 0; k2 < 2; k2++){
                        int x2 = location[j][k2 == 0 ? 0 : 1];
                        int y2 = location[j][k2 == 0 ? 1 : 0];
                        //가로 + 가로
                        int x = x1 + x2;
                        int y = Math.max(y1,y2);
                        //전체에서 작은거 빼기
                        if(w >= x && h >= y){
                            max = Math.max(max, (y1 * x1 + y2 * x2));
                        }
                        //세로 + 세로
                        x = Math.max(x1, x2);
                        y = y1 + y2;
                        if(w >= x && h >= y){
                            max = Math.max(max, (y1 * x1 + y2 * x2));
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
