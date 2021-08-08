package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
100 40021
 */
public class A_B_16953 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int result = 1;

        while(target != n) {

            if(target == 0) {
                result = -1;
                break;
            }

            if(target % 2 == 0) {
                target /= 2;
                result++;
            } else if (target % 10 == 1){
                target /= 10;
                result++;
            } else {
                result = -1;
                break;
            }
        }
        System.out.println(result);
    }
}
