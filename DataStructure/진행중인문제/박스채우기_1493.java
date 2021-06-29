package DataStructure.진행중인문제;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*
4 4 8
3
0 10
1 10
2 1
 */

/**
 * 시간 복잡도 - 최대 큐브의 개수 = 10^6 * 20
 */
public class 박스채우기_1493 {

    private static int[] box;
    private static int result = 0;
    private static boolean check = false;

    private static void fillCube(int length, int width, int height, int idx) {

        if(idx == -1) {
            if (length * width * height > 0) check = true;
            return;
        }
            //길이가 idx인 큐브의 크기
        int cubeCount = box[idx];
        int cubeLen = (1 << idx);
        if(cubeCount < 1 || length - cubeLen < 0 || width - cubeLen < 0 || height - cubeLen < 0) {
            fillCube(length, width, height, idx - 1);
            //3가지 방향으로 채우기
            return;
        }
        box[idx]--;
        result++;
        fillCube(length - cubeLen, width, height, idx );
        fillCube(length, width - cubeLen, height, idx );
        fillCube(length, width, height - cubeLen, idx );
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(input.readLine());

        box = new int[n];
        for(int i = n - 1; i >= 0; i--){
            st = new StringTokenizer(input.readLine());
            int idx = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            box[idx] = cnt;
        }

        fillCube(length, width, height,n - 1);
        System.out.println(result);
    }
}
