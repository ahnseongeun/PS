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
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int[] ipMin = new int[4];
        int[] ipMax = new int[4];
        Arrays.fill(ipMin, 255);

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(input.readLine(), ".");
            for(int j = 0; j < 4; j++){
                int num = Integer.parseInt(st.nextToken());
                ipMin[j] = Math.min(ipMin[j],num);
                ipMax[j] = Math.max(ipMax[j],num);
            }
        }
        System.out.println(ipMin[0]);
        System.out.println(ipMax[0]);

        int[] mask = new int[4];
        boolean flag = false;
        for(int i = 0; i < 4; i++){
            mask[i] = 255;
            if(ipMin[i] == ipMax[i]) continue;
            int diff = ipMax[i] - ipMin[i] + 1;
            System.out.println(diff);
            int num = 0;
            for(int j = 8; j > 0; j--){
                num = (1 << j);
                if(num < diff) {
                    mask[i] = 256 - num;
                    flag = true;
                    break;
                }else if(num == diff){
                    System.out.println(num);
                    mask[i] = 256 - num;
                    flag = true;
                    break;
                }
            }

            if(flag)
                break;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 4; i++)
            sb.append(mask[i] & ipMax[i]).append(".");
        String str1 = sb.substring(0,sb.length() - 1);
        sb = new StringBuilder();
        for(int i = 0; i < 4; i++)
            sb.append(mask[i]).append(".");
        String str2 = sb.substring(0,sb.length() - 1);
        System.out.println(str1 + "\n" + str2);
    }
}
