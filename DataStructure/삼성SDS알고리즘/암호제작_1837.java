package DataStructure.삼성SDS알고리즘;

import DataStructure.Stack.압축_1662_String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/*
143 10
 */

/**
 * K보다 작은 소수로 N이 나누어 떨어지는지 검사하는 것이 궁극적인 목표
 * 매우 큰 N을 어떻게 작은 소수 T로 나누어 떨어지는지 알 수 있을까?
 *  -> 나눗셈의 기본 계속해서 T로 나눠가면서 나머지를 이용한다.
 * N을 앞에서 부터 T롤 MOD하면서 최종 결과 값이 0이라면 나누어 떨어진다.
 */
public class 암호제작_1837 {

    public static boolean checkBad(int x, String str) {

        int ret = 0;

        for(int i = 0; i < str.length(); i++) {
            ret = (ret * 10 + (str.charAt(i) - '0')) % x;
        }

        if( ret == 0) return true;
        return false;
    }


    public static void main(String[] args) throws Exception{

        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(input.readLine());
        String str = st.nextToken(); //문자열
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken()); //k는 최대 범위
        boolean check = false;

        int result = 0;

        boolean[] checked = new boolean[k + 1];

        //k범위 안에 소수가 아닌 부분 제외하기
        for( int i = 2; i < k; i++) {

            //소수가 아니라면 continue
            if( checked[i] ) continue;

            //해당 소수로 나누어 떨어지면 break;
            if( checkBad(i, str)) {
                result = i;
                check = true;
                break;
            }
            // 에라토스테네스의 체 -> i를 제외한 모든 i의 배수를 체크한다.
            for(int j = i + i; j < k; j += i) {
                checked[j] = true;
            }
        }


        if( check ) {
            sb.append("BAD ").append(result);
        } else {
            sb.append("GOOD");
        }

        System.out.println(sb);
    }
}
