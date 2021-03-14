package CodingTest.다날;

import JAVA.문자열_TO_INT;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 개미수열은 다음과 같은 수열입니다. (이 수열은 소설 "개미"에서 소개되었기 때문에 개미 수열이라고 불립니다.)
 *
 * 1, 11, 12, 1121, 122111 .....
 * 이 수열은 앞의 수의 연속된 같은 숫자를 묶어서 숫자와 그 개수를 읽는 방식으로 만들어집니다.
 *
 * 1을 "1이 한 개" 혹은 11로 읽습니다.
 * 11을 "1이 두 개" 혹은 12로 읽습니다.
 * 12를 "1이 한 개, 2가 한 개" 혹은 1121로 읽습니다.
 * 1121을 "1이 두 개, 2가 한 개, 1이 한 개" 혹은 122111로 읽습니다.
 * 이와 같은 방법으로 계속해서 다음 수를 만들어 갑니다.
 * 입력으로 n 이 주어질 때 n번째 개미 수열을 문자열 형태로 return 하도록 solution 함수를 완성해주세요.
 */
public class TEST2 {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String[] per = new String[41];

        sb.append("1");
        per[1] = sb.toString();
        sb.append("1");
        per[2] = sb.toString();
        int n = 28;

        for(int i = 3; i <= n; i++){
            sb = new StringBuilder();
            String str = per[i - 1];
            int cnt = 1;
            char tmp = str.charAt(0);
            sb.append(tmp);
            for(int j = 0; j < str.length() - 1; j++){
                if(tmp == str.charAt(j + 1)){
                    cnt ++;
                    continue;
                }
                tmp = str.charAt(j + 1);
                sb.append(cnt +""+ tmp);
                cnt = 1;

            }
            sb.append(cnt);
            per[i] = sb.toString();
        }
        System.out.println(per[n]);
    }
}

