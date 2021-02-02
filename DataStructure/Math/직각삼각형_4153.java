package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

/*
6 8 10
25 52 60
5 12 13
0 0 0
 */
public class 직각삼각형_4153 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            StringTokenizer st = new StringTokenizer(input.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0)
                break;
            List<Integer> list = new LinkedList<>();
            list.add(a); list.add(b); list.add(c);
            Collections.sort(list);
            int a3 = list.get(2);
            int a2 = list.get(1);
            int a1 = list.get(0);
            if (a3 * a3 == a2 * a2 + a1 * a1) {
                sb.append("right\n");
            } else {
                sb.append("wrong\n");
            }
        }
        System.out.println(sb);
    }
}
