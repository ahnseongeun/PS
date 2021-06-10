package DataStructure.비트마스크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/*
12 1 449 12 555 1201 912 555 19372
 */
/**
 * 걸리 시간 2.4초
 * 사용된 공간 525532
 */
public class 중복제거_13701 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(input.readLine());
        Set<Integer> set = new HashSet<>();
        int n = 0;
        while(st.hasMoreTokens()){
            n = Integer.parseInt(st.nextToken());
            if(set.add(n)) sb.append(n).append(" ");
        }
        System.out.println(sb);

    }
}
