package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ACM호텔_10250 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());

        for(int i = 0 ;i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine());

            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int front = k % h == 0 ? h : k % h;
            int rear = k % h == 0? k / h : k / h + 1;
            String str = rear < 10 ? "0"+rear: String.valueOf(rear);
            System.out.println(front+str);
        }
    }
}
