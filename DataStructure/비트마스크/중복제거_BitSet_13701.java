package DataStructure.비트마스크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * 걸린 시간 1.2초
 * 사용된 공간 371552 KB
 */
public class 중복제거_BitSet_13701 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        StringBuilder sb = new StringBuilder();
        BitSet set = new BitSet();

        while(st.hasMoreTokens()){
            int n = Integer.parseInt(st.nextToken());
            if(!set.get(n)) {
                set.set(n);
                sb.append(n).append(" ");
            }
        }
        System.out.println(sb);
    }
}
