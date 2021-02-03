package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class 요세푸스문제3_11025번 {
    public static void main(String[] args) throws Exception {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
//        for(int i = 1; i <= n ;i++)
//            list.add(i);

        int idx = m - 1;
        int result = 0;
        while(true){
            if(n == 1){
                result = idx;
                break;
            }
            idx = (idx + m - 1) % n;
            n--;
        }
        System.out.println(result);
    }
}
