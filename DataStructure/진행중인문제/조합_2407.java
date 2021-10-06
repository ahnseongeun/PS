package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 조합_2407 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long up = n;
        long down = m;
        int size = m;
        for(int i = 1; i < size; i++) {
            if(up % down == 0) up /= down;
            up *= --n;
            down *= --m;
        }
        System.out.println(up);
    }
}
