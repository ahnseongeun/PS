package DataStructure.Math;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/**
 * (a,b,c) = (a+b+c) + (a*b + a*c + b*c) + (a * b * c) + 1 = (a + 1) * (b + 1) * (c + 1)
 * 곱셈 공식...
 */
public class 패션왕신해빈_9375 {

    private static int calculateNumbersOfCases(HashMap<String, Integer> map) {
        LinkedList<Integer> list = new LinkedList<>(map.values());
        int result = 1;
        for(int a : list)
            result *= (a + 1);
        //identity는 초기값
        //result = list.stream().reduce(1,(integer, integer2) -> integer * integer2);
        return result;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(input.readLine());

        for(int i = 0; i < n; i++){
            int m = Integer.parseInt(input.readLine());
            HashMap<String,Integer> map = new HashMap<>();

            for(int j = 0; j < m; j++){
                StringTokenizer st = new StringTokenizer(input.readLine());
                String value = st.nextToken();
                String key = st.nextToken();
                map.put(key,map.getOrDefault(key,0) + 1);
            }
            sb.append(calculateNumbersOfCases(map)).append("\n");
        }
        System.out.println(sb);
    }
}
