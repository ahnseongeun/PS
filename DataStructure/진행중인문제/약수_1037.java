package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class 약수_1037 {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        StringTokenizer st = new StringTokenizer(input.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            int val = Integer.parseInt(st.nextToken());
            int maxVal = val;
            for(int j = 2; j <= maxVal; j++) {
                if(val == 1) break;
                if(val % j == 0) {
                    val %= j;
                }
            }
        }

    }
}
