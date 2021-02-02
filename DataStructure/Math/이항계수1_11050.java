package DataStructure.Math;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 이항계수1_11050 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int upSum = 1;
        int downSum = 1;
        for(int i = 0; i < k ;i++){
            upSum *= n;
            n--;
        }
        for(int i = k; i > 0 ;i--){
            downSum *= i;
        }
        System.out.println(upSum/downSum);
    }
}
