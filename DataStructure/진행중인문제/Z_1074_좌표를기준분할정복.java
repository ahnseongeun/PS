package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z_1074_좌표를기준분할정복 {

    static int count;
    static int r;
    static int c;

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int a = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int n = (int) Math.pow(2,a);
        count = 0;
        fillArray(n,0,0);
    }

    private static void fillArray(int n, int i, int i1) {
    }

}
