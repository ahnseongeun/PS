package DataStructure.비트마스크;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 비트마스크로 푸는 방법
 * target을 이진수로 변환
 * 0000000부터 시작해서 자리수마다 1씩 비교하기
 *
 */
public class 막대기_1094 {
    public static void main(String[] args) throws Exception{
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(input.readLine());
        int cnt = 0;

        System.out.println(1 << 2);

        for (int i = 0; i < 7; i++) {
            if((n & (1 << i)) > 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
