package DataStructure.진행중인문제;

import javax.swing.plaf.basic.BasicButtonUI;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

/*
4 4 8
3
0 10
1 10
2 1
 */
public class 박스채우기_1493 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        HashMap<Integer, Integer> box = new HashMap<>();
        int length = Integer.parseInt(st.nextToken());
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int n = Integer.parseInt(input.readLine());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(input.readLine());
            box.put((int) Math.pow(2,Integer.parseInt(st.nextToken())), Integer.parseInt(st.nextToken()));
        }
        System.out.println(box.get(2));
    }
}
