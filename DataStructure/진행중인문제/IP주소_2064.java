package DataStructure.진행중인문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.BitSet;
import java.util.StringTokenizer;

/**
 * 1. IP주소에 네트워크 마스크를 &하면 네트워크 주소가 나온다.
 */
/*
3
194.85.160.177
194.84.160.183
194.85.160.178
2
194.85.160.130
194.85.160.133
 */
public class IP주소_2064 {
    private static BitSet bitSet = new BitSet(32);
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        String[] ip = new String[n];


        for(int i = 0; i < n; i++) ip[i] = input.readLine();
        for(int i = 0; i < 32; i++) bitSet.set(i,true);

        for(int i = 0; i < n - 1; i++){
            String ip1 = ip[i];
            String ip2 = ip[i + 1];
        }





//        StringBuilder sb = new StringBuilder();
//        for(int i = 0; i < 4; i++)
//            sb.append(mask[i] & ipMax[i]).append(".");
//        String str1 = sb.substring(0,sb.length() - 1);
//        sb = new StringBuilder();
//        for(int i = 0; i < 4; i++)
//            sb.append(mask[i]).append(".");
//        String str2 = sb.substring(0,sb.length() - 1);
//        System.out.println(str1 + "\n" + str2);
    }
}
