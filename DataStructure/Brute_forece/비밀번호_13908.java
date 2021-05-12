package DataStructure.Brute_forece;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
2 1
7
07, 17, 27, 37, 47, 57, 67, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 87, 97이다.

2 2
3 4
34, 43
 */

/**
 * 완전 탐색으로 모든 경우를 계산한 후에
 * 조건에 맞는다면 count + 1을 증가시켜주는 문제이다.
 */
public class 비밀번호_13908 {

    private static int n, m;
    private static boolean know[];
    private static int result[];
    private static boolean visited[];
    private static int getPassword(int idx) {

        int sum = 0;
        if(idx == n) {
            if(check())
                return 1;
            return 0;
        }

        for(int i = 0; i < 10; i++){
            result[idx] = i;
            sum += getPassword(idx + 1);
        }
        return sum;
    }

    private static boolean check() {
        boolean flag = false;
        for(int i = 0; i < result.length; i++){
            if(know[result[i]])
                visited[result[i]] = true;
        }
        for(int i = 0; i < 10; i++){
            if(know[i]){
                if(!visited[i]){
                    flag = true;
                    break;
                }
            }
        }

        Arrays.fill(visited,false);
        if(!flag)
            return true;
        else
            return false;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        know = new boolean[10];
        visited = new boolean[10];
        result = new int[n];
        st = new StringTokenizer(input.readLine());
        for(int i = 0; i < m; i++){
            int k = Integer.parseInt(st.nextToken());
            know[k] = true;
        }
        System.out.println(getPassword(0));
    }
}
